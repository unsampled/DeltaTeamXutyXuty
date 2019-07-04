package deltateam;
//TODO:unused imports
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
//TODO: unused imports
import java.security.Key;

public class Menu implements KeyboardHandler {
    //TODO: package-private access
    Keyboard keyboard;
    private boolean startGame;

    public Menu(){
        keyboard = new Keyboard(this);
        //TODO:useless comments
        //Rectangle rectangle = new Rectangle(0,0,1200,800);
        //rectangle.draw();
        Picture picture = new Picture(0,0,"./Resources/menuXutyXuty.png");
        picture.draw();
        init();
    }

    public boolean isStartGame() {
        return startGame;
    }

    private void init(){
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardEvent);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //TODO: 1 case switch
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
                startGame = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
