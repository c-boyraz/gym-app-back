package com.lihtnegym.lihtne_gym.service;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}
