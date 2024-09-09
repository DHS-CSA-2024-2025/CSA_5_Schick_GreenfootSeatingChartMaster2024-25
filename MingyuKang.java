import greenfoot.*;
import java.util.ArrayList;

public class MingyuKang extends Student implements SpecialInterestOrHobby {
    private ArrayList<ErrorWindow> errorWindows = new ArrayList<>();
    private long startTime;
    private static final int ERROR_DURATION = 7000; 
    private static final int BLUESCREEN_DURATION = 3000; 
    private static final int TOTAL_DURATION = ERROR_DURATION + BLUESCREEN_DURATION;
    private Actor blueScreen;

    public MingyuKang() {
        firstName = "Mingyu";
        lastName = "Kang";
        mySeatX = 5;
        mySeatY = 4;
        portraitFile = "mingyukang.png";
        //standingFile
        soundFile = firstName.toLowerCase() + lastName.toLowerCase() + ".wav";
        setImage(portraitFile);
        sitting = true;
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("mingyukang.wav");
            startAnimation();
        }

        if (startTime > 0) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;

            if (elapsedTime < ERROR_DURATION) {
                if (Greenfoot.getRandomNumber(100) < 20) { 
                    addNewErrorWindow();
                }
            } else if (elapsedTime < TOTAL_DURATION) {
                if (blueScreen == null) {
                    clearErrorWindows();
                    showBlueScreen();
                }
            } else {
                endAnimation();
            }
        }
    }

    private void startAnimation() {
        startTime = System.currentTimeMillis();
        clearErrorWindows();
    }

    private void addNewErrorWindow() {
        if (getWorld() != null) {
            ErrorWindow newError = new ErrorWindow();
            int x = Greenfoot.getRandomNumber(getWorld().getWidth());
            int y = Greenfoot.getRandomNumber(getWorld().getHeight());
            getWorld().addObject(newError, x, y);
            errorWindows.add(newError);
        }
    }

    private void clearErrorWindows() {
        for (ErrorWindow window : errorWindows) {
            if (getWorld() != null) {
                getWorld().removeObject(window);
            }
        }
        errorWindows.clear();
    }

    private void showBlueScreen() {
        if (getWorld() != null) {
            blueScreen = new Actor() {
                {
                    setImage("bluescreen.png");
                }
            };
            getWorld().addObject(blueScreen, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }

    private void endAnimation() {
        if (getWorld() != null && blueScreen != null) {
            getWorld().removeObject(blueScreen);
        }
        blueScreen = null;
        startTime = 0;
    }

    @Override
    public void getName() {
        System.out.println(firstName + " " + lastName);
    }

    @Override
    public void myHobby(String myHobbySentence) {
        System.out.println(myHobbySentence);
    }
}

class ErrorWindow extends Actor {
    public ErrorWindow() {
        setImage("error.png");
    }
}