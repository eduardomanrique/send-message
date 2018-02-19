package com.eduardomanrique.sendmessage.service;

import com.eduardomanrique.sendmessage.entity.EmailMessage;
import com.eduardomanrique.sendmessage.entity.Phone;
import com.eduardomanrique.sendmessage.entity.SmsMessage;
import com.eduardomanrique.sendmessage.repository.MessageRepository;
import com.eduardomanrique.sendmessage.sender.MessageSender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;
    @Mock
    private MessageSender sender;
    @InjectMocks
    private MessageServiceImpl messageService;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEmail() {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("from");
        emailMessage.setTo("to");
        emailMessage.setTitle("title");
        emailMessage.setBody("body");
        messageService.send(emailMessage);

        verify(sender, atLeastOnce()).send(emailMessage);
        verify(messageRepository, atLeastOnce()).save(emailMessage);
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
        messageService.send(smsMessage);

        verify(sender, atLeastOnce()).send(smsMessage);
        verify(messageRepository, atLeastOnce()).save(smsMessage);
    }
}
