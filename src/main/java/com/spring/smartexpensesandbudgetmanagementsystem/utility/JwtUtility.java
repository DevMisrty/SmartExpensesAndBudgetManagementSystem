package com.spring.smartexpensesandbudgetmanagementsystem.utility;

import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtility {

    private SecretKey getKey(){
        String key = "B*R=^@V^n$%p>0m9&@8:3Yk$J$]2q'1XW,`J2$V/u@q7hN+g;@3`9-Lr<YCi?Z4e6b]$3>uU5gA9zI%[m<kN6wT7vM1P9o+R|Y8bL1cC2dS9jH5uR0gQ@X~aZ;fJ2m%V1hT8yC3n$K5rE0lB8qO4mP1iJ9uF5wY7xH6tR2pN8sM4cL0zD7aG3vE1bW5qT9uH0oF4nL8jR2yM6kC3pV1xB9aT7oE0uN5lY3rJ2hW8cZ4fK0dM9vQ1gB5aX7pR2tU8yN4mO6sC1jL3eH5gA9nW0qT8yP4lU2kN7vB5oE3mC9pL4rJ1aF6tZ8gX2uY7nO5wH0sQ3dP9vK4cM2rN8bJ5yL7uF1hG0pW3aX9tZ4eK2oQ8mC1nV5rY7lB6jH0uS3wT9pM2gN8fD4oL1aE7kQ6xY3bV9cZ4rH5tM1uF8nO2wG6yJ0qP3lK7dX4vB9gF2mY8hC5oN1tS6jR0wU3pL9qK4eH8yZ2rF7vB1aT5nO9cM6gW4xJ0uQ3lE8pK7dH2tY5nV1mC9oR6yB8aF4gU0wS3xZ7qP5jN2tK1uM8eH9rF0vL6bG4yJ2pQ5nV1oW8xC7aT9gM2lR4jH0yE3uP6tB1vN9oK4fX2gQ7yC5nV8lW0rJ3aF9tZ6mO4uP2dK8yX1hG5wQ3cB7nT9vL0pM2oF8rJ1gY6xE4hC9tB7mN3kP0vZ2yL8qR5fT7aG1wU9oJ4nX6hM3pC8vD5tB1gF7rK0yE2uL9mW4xN7qP8hJ3dV1aZ6gR0cM9oK5wB2yX7tL3uN4pF8mH1vJ0gR9kC6xE3aP4qT8yB7nV1oW9mU2dH5rK3fG6cY0lQ7pX4tE1nJ8wV9oF2gM6bL3yH7kC4rN0uP5tB1aX9wZ2oY8lJ6vQ3gF7cT5mR4nP1yB0xE2hL8wJ9oK7vU6nY3pC5mH4tR8gB1fN2oZ0yW7qT6uP3lV9xJ4aG8rK2eM1hC5wB7nX0oF9pQ3tZ6uV8gW1lR2yK7aB4mN0cE5hT8wG9qP6xJ2nL4oY1vM3rH5gF7uB0pK9zE2tN8yW4mQ3cV5aX1oU6rL9pH7gT0kC8nR2wJ5yB3fM4oG9tV1qU8hK6xL0 ";
        return Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
    }

    public String getAccessToken(Users users){
        return Jwts.builder()
                .setSubject(users.getUsername())
                .claim("role",users.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .signWith(getKey())
                .compact();
    }

    public String getUsernamefromToken(String token){
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isValidToken(String token){
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration()
                .after(new Date());
    }
}
