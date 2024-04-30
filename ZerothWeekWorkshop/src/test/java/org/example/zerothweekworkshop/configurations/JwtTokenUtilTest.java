package org.example.zerothweekworkshop.configurations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class JwtTokenUtilTest {

    @Mock
    private UserDetails userDetails;

    @SpyBean
    private JwtTokenUtil jwtTokenUtil;

    private String username;
    private String token;

    @BeforeEach
    void setUp() {
        username = "testUser";
        token = jwtTokenUtil.generateToken(username);
    }

    @Test
    void testGenerateToken() {
        assertNotNull(token);
        assertEquals(username, jwtTokenUtil.extractUsername(token));
    }

    @Test
    void testExtractUsername() {
        assertEquals(username, jwtTokenUtil.extractUsername(token), "Extracted username should match the original.");
    }

    @Test
    void testTokenExpiration() {
        assertFalse(jwtTokenUtil.isTokenExpired(token));

        // Advance time by simulating time after token expiration
        Mockito.doReturn(new Date(System.currentTimeMillis() + 1000 * 60 * 31)) // 31 minutes later
                .when(jwtTokenUtil)
                .getCurrentTime();

        assertTrue(jwtTokenUtil.isTokenExpired(token));
    }
}