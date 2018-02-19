package com.eduardomanrique.sendmessage.sender;

import com.eduardomanrique.sendmessage.entity.EmailMessage;
import com.eduardomanrique.sendmessage.entity.Phone;
import com.eduardomanrique.sendmessage.entity.SmsMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageSenderTest {

    @Mock
    private Sender<EmailMessage> senderEmail;
    @Mock
    private Sender<SmsMessage> senderSms;
    @Spy
    private Map<String, Sender> senderMap = new HashMap<>();
    @InjectMocks
    private MessageSender messageSender;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
        senderMap.put("emailMessageSender", senderEmail);
        senderMap.put("smsMessageSender", senderSms);
    }

    @Test
    public void testEmail() {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("from");
        emailMessage.setTo("to");
        emailMessage.setTitle("title");
        emailMessage.setBody("body");
        messageSender.send(emailMessage);

        verify(senderEmail, atLeastOnce()).send(emailMessage);
        verify(senderSms, never()).send(any());
    }

    @Test
    public void testSms() {
        SmsMessage smsMessage = new SmsMessage();
        Phone from = new Phone();
        from.setCountry(55);
        from.setNumber("12341234");
        smsMessage.setFrom(from);

        Phone to = new Phone();
        to.setCountry(48);
        to.setNumber("13423455");
        smsMessage.setTo(to);
        smsMessage.setText("text");
        messageSender.send(smsMessage);

        verify(senderSms, atLeastOnce()).send(smsMessage);
        verify(senderEmail, never()).send(any());
    }
}
