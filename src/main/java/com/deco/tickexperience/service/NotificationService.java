package com.deco.tickexperience.service;

import com.deco.tickexperience.model.entity.Ticket;
import com.deco.tickexperience.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.util.LinkedMultiValueMap;

@Service
@RequiredArgsConstructor
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mailgun.api_key}")
    private String MAILGUN_API_KEY;

    @Value("${mailgun.api_url}")
    private String MAILGUN_API_URL;

    @Value("${mailgun.domain}")
    private String MAILGUN_DOMAIN;

    public void sendConfirmationEmail(User user, Ticket ticket) {
        sendEmail(user.getEmail(), "Ticket confirmation", "Congratulations on purchasing a ticket to minky poo");
    }

    public void sendEmail(String to, String subject, String text) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("api", MAILGUN_API_KEY);

        String from = "Gold Pass" + MAILGUN_DOMAIN;

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("from", from);
        body.add("to", to);
        body.add("subject", subject);
        body.add("text", text);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        try {
            restTemplate.exchange(
                    MAILGUN_API_URL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );
        } catch (HttpClientErrorException e) {
            System.err.println("Email request failed: " + e.getMessage());
        } catch (RestClientException e) {
            System.err.println("REST client error: " + e.getMessage());
        }
    }
}
