package com.eduardomanrique.sendmessage.integration;

import com.eduardomanrique.sendmessage.entity.EmailMessage;
import com.eduardomanrique.sendmessage.entity.Phone;
import com.eduardomanrique.sendmessage.entity.SmsMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void sendInvalidEmail() {
        EmailMessage emailMessage = new EmailMessage();
        ResponseEntity<Void> responsePost = restTemplate.postForEntity("/send", emailMessage, Void.class);
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responsePost.getStatusCode());
    }

    @Test
    public void sendInvalidSms() {
        SmsMessage smsMessage = new SmsMessage();
        ResponseEntity<Void> responsePost = restTemplate.postForEntity("/send", smsMessage, Void.class);
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responsePost.getStatusCode());
    }

    @Test
    public void send2MessagesAndCheckReturnFromListAll() {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("from");
        emailMessage.setTo("to");
        emailMessage.setTitle("title");
        emailMessage.setBody("body");

        ResponseEntity<Void> responsePost = restTemplate.postForEntity("/send", emailMessage, Void.class);
        Assert.assertEquals(HttpStatus.OK, responsePost.getStatusCode());

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
        responsePost = restTemplate.postForEntity("/send", smsMessage, Void.class);
        Assert.assertEquals(HttpStatus.OK, responsePost.getStatusCode());

        ResponseEntity<List> responseEntity =
                restTemplate.getForEntity("/list", List.class);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(2, responseEntity.getBody().size());
    }
}