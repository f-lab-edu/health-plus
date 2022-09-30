package org.healthplus.wrapper;

import org.healthplus.exception.ApplicationUserNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NameTest {


    @Test
    public void nameInitTest() throws Exception {
        assertThatCode(() -> Name.from("Lee"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "HelloWorldNameTest"})
    public void nameExceptionTest(String name) throws Exception {
        assertThatThrownBy(() -> Name.from(name))
                .isInstanceOf(ApplicationUserNameException.class);
    }

    @Test
    public void nameChangeTest() throws Exception {
        Name name = Name.from("Lee");
        name.changeName("park");
        assertThat(name.currentName()).isEqualTo("park");
    }

}
