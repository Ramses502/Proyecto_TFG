import com.dadm.model.User;
import com.dadm.ports.infrastructure.UserDbPort;
import com.dadm.services.UserUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserTest {

    @InjectMocks
    private UserUseCase userUseCase;
    @Mock
    private UserDbPort userDbPort;

    @Test
    void loginWithPasswordWrong() {
        String name = "testing";
        String password = "passwordWrong";

        assertThrows(RuntimeException.class,
                () -> userUseCase.login(name, password));
        verify(userDbPort).login(any(), any());
    }

    @Test
    void loginWithNameWrong() {
        String name = "testingg";
        String password = "password";

        assertThrows(RuntimeException.class,
                () -> userUseCase.login(name, password));
        verify(userDbPort).login(any(), any());
    }

    @Test
    void loginWithAllCorrect() {
        String name = "testing";
        String password = "password";
        User user = User.builder().name(name).password(password).build();
        when(userDbPort.login(name, password)).thenReturn(user);

        User userLogged = userUseCase.login(name, password);

        verify(userDbPort).login(any(), any());
        assertEquals(name, userLogged.getName());
        assertEquals(password, userLogged.getPassword());
    }
}
