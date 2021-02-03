package clone.studyolle.app.config;


import clone.studyolle.app.controller.MainController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@WebMvcTest(MainController.class)
@ExtendWith(MockitoExtension.class)
class SecurityConfigTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("시큐리티 로그인 필터 테스트")
    void LoginTest() throws Exception {
        mockMvc.perform(get("/login").
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().string("/login")).
                andDo(print());
    }
    @Test
    @DisplayName("시큐리티 Post 프로필 필터 테스트->실패 테스트")
    void ProfileFail() throws Exception {
        mockMvc.perform(post("/profile/*").
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().string("/profile/*")).
                andDo(print());
    }
    @Test
    @DisplayName("시큐리티 get 프로필 필터 테스트->성공 테스트")
    void ProfileSuccess() throws Exception {
        mockMvc.perform(get("/profile/*").
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().string("/profile/*")).
                andDo(print());
    }

}