package graph;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class MyFrameTest {

    private FrameFixture window;

    @Before
    public void setUp() {
        MyFrame frame = GuiActionRunner.execute(() -> new MyFrame());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void checkTextFieldStart() {
        window.textBox("textFieldStart").enterText("");
        window.button("buttonFindWay").click();
        window.textBox("textFieldWay").requireText("Ошибка! Заполните все поля ввода");
        window.button("buttonClear").click();

        window.textBox("textFieldStart").enterText("asdf");
        window.button("buttonFindWay").click();
        window.textBox("textFieldWay").requireText("Ошибка! Заполните все поля ввода");
        window.button("buttonClear").click();

        window.textBox("textFieldStart").enterText("3");
        window.button("buttonFindWay").click();
        window.textBox("textFieldWay").requireText("Ошибка! Заполните все поля ввода");
        window.button("buttonClear").click();

        window.textBox("textAreaMatrix").enterText("0 1 1 1 0\n1 0 0 1 0\n1 0 0 0 0\n1 1 0 0 1\n0 0 0 1 0");
        window.textBox("textFieldStart").enterText("0 1");
        window.textBox("textFieldFinish").enterText("4");
        window.button("buttonFindWay").click();
        window.textBox("textFieldWay").requireText("Ошибка! Некорректные вершины");
        window.button("buttonClear").click();
    }

//    @Test
//    public void checkTextFieldFinish() {
//        window.textBox("textFieldFinish").enterText("");
//        window.button("buttonFindWay").click();
//        window.textBox("textFieldWay").requireText("Ошибка! Заполните все поля ввода");
//        window.button("buttonClear").click();
//
//        window.textBox("textFieldFinish").enterText("asdf");
//        window.button("buttonFindWay").click();
//        window.textBox("textFieldWay").requireText("Ошибка! Заполните все поля ввода");
//        window.button("buttonClear").click();
//
//        window.textBox("textFieldFinish").enterText("5");
//        window.button("buttonFindWay").click();
//        window.textBox("textFieldWay").requireText("Ошибка! Заполните все поля ввода");
//        window.button("buttonClear").click();
//
//        window.textBox("textAreaMatrix").enterText("0 1 1 1 0\n1 0 0 1 0\n1 0 0 0 0\n1 1 0 0 1\n0 0 0 1 0");
//        window.textBox("textFieldStart").enterText("0");
//        window.textBox("textFieldFinish").enterText("4 d");
//        window.button("buttonFindWay").click();
//        window.textBox("textFieldWay").requireText("Ошибка! Некорректные вершины");
//        window.button("buttonClear").click();
//    }
//
//    @Test
//    public void checkButtonClear() {
//        window.textBox("textFieldStart").enterText("asdf");
//        window.textBox("textFieldFinish").enterText("gweg ");
//        window.textBox("textAreaMatrix").enterText("0 1 0\n1 0 0\n1 1 0");
//        window.button("buttonClear").click();
//        window.textBox("textFieldWay").requireText("");
//        window.textBox("textAreaMatrix").requireText("");
//        window.textBox("textFieldStart").requireText("");
//        window.textBox("textFieldFinish").requireText("");
//
//        window.textBox("textAreaMatrix").enterText("0 1 1 1 0\n1 0 0 1 0\n1 0 0 0 0\n1 1 0 0 1\n0 0 0 1 0");
//        window.textBox("textFieldStart").enterText("0");
//        window.textBox("textFieldFinish").enterText("4");
//        window.button("buttonClear").click();
//        window.textBox("textFieldWay").requireText("");
//        window.textBox("textAreaMatrix").requireText("");
//        window.textBox("textFieldStart").requireText("");
//        window.textBox("textFieldFinish").requireText("");
//    }
//
//    @Test
//    public void correctData() {
//        window.textBox("textAreaMatrix").enterText("0 1 1 1 0\n1 0 0 1 0\n1 0 0 0 0\n1 1 0 0 1\n0 0 0 1 0");
//        window.textBox("textFieldStart").enterText("0");
//        window.textBox("textFieldFinish").enterText("4");
//        window.button("buttonFindWay").click();
//        window.textBox("textFieldWay").requireText("0 1 3 4");
//        window.button("buttonClear").click();
//        window.textBox("textFieldWay").requireText("");
//        window.textBox("textAreaMatrix").requireText("");
//        window.textBox("textFieldStart").requireText("");
//        window.textBox("textFieldFinish").requireText("");
//
//        window.textBox("textAreaMatrix").enterText("0 1 1 1 0 0\n1 0 0 0 0 0\n1 0 0 0 1 0\n1 0 0 0 0 1\n0 0 1 0 0 0\n0 0 0 1 0 0");
//        window.textBox("textFieldStart").enterText("0");
//        window.textBox("textFieldFinish").enterText("5");
//        window.button("buttonFindWay").click();
//        window.textBox("textFieldWay").requireText("0 3 5");
//        window.button("buttonClear").click();
//        window.textBox("textFieldWay").requireText("");
//        window.textBox("textAreaMatrix").requireText("");
//        window.textBox("textFieldStart").requireText("");
//        window.textBox("textFieldFinish").requireText("");
//
//        window.textBox("textAreaMatrix").enterText("0 1 1 1 0 0\n1 0 0 0 0 0\n1 0 0 0 1 0\n1 0 0 0 0 1\n0 0 1 0 0 0\n0 0 0 1 0 0");
//        window.textBox("textFieldStart").enterText("4");
//        window.textBox("textFieldFinish").enterText("6");
//        window.button("buttonFindWay").click();
//        window.textBox("textFieldWay").requireText("No way out.");
//        window.button("buttonClear").click();
//        window.textBox("textFieldWay").requireText("");
//        window.textBox("textAreaMatrix").requireText("");
//        window.textBox("textFieldStart").requireText("");
//        window.textBox("textFieldFinish").requireText("");
//
//        window.textBox("textAreaMatrix").enterText("1 0\n0 1");
//        window.textBox("textFieldStart").enterText("0");
//        window.textBox("textFieldFinish").enterText("1");
//        window.button("buttonFindWay").click();
//        window.textBox("textFieldWay").requireText("No way out.");
//        window.button("buttonClear").click();
//        window.textBox("textFieldWay").requireText("");
//        window.textBox("textAreaMatrix").requireText("");
//        window.textBox("textFieldStart").requireText("");
//        window.textBox("textFieldFinish").requireText("");
//    }
//
//    @Test
//    public void doubleClickButtonFindWay() {
//        window.textBox("textAreaMatrix").enterText("0 1 1 1 0\n1 0 0 1 0\n1 0 0 0 0\n1 1 0 0 1\n0 0 0 1 0");
//        window.textBox("textFieldStart").enterText("0");
//        window.textBox("textFieldFinish").enterText("4");
//        window.button("buttonFindWay").doubleClick();
//        window.textBox("textFieldWay").requireText("0 1 3 4");
//        window.button("buttonClear").click();
//        window.textBox("textFieldWay").requireText("");
//        window.textBox("textAreaMatrix").requireText("");
//        window.textBox("textFieldStart").requireText("");
//        window.textBox("textFieldFinish").requireText("");
//    }
//
//    @Test
//    public void textAreaCheck() {
//        window.textBox("textAreaMatrix").enterText("bad Data");
//        window.textBox("textFieldStart").enterText("0");
//        window.textBox("textFieldFinish").enterText("4");
//        window.button("buttonFindWay").click();
//        window.textBox("textFieldWay").requireText("");
//        window.button("buttonClear").click();
//        window.textBox("textFieldWay").requireText("");
//        window.textBox("textAreaMatrix").requireText("");
//        window.textBox("textFieldStart").requireText("");
//        window.textBox("textFieldFinish").requireText("");
//    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

}
