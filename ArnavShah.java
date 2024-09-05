import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ArnavShah class represents a student in the classroom and handles the animations when clicked.
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class ArnavShah extends Student implements SpecialInterestOrHobby
{
    private static final int flipSteps = 36; // Number of steps for 360-degree flip
    private static final int resizeSteps = 10; // Number of steps for resizing
    private static final int Delay = 5; // Delay between animation steps
    
    public ArnavShah(String f, String l, int r, int s) {
        firstName = f;
        lastName = l;
        mySeatX = r;
        mySeatY = s;
        portraitFile = f.toLowerCase() + l.toLowerCase() + ".jpg"; // Make sure to name your image files firstlast.jpg, all lowercase!!!
        //standingFile = firstName.toLowerCase() + lastName.toLowerCase() + "-standing.jpg";
        //soundFile = f.toLowerCase() + l.toLowerCase() + ".wav"; // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting = true;
    }
    
    public ArnavShah() {
        firstName = "Arnav";
        lastName = "Shah";
        mySeatX = 1;
        mySeatY = 1;
        portraitFile = firstName.toLowerCase() + lastName.toLowerCase() + ".jpg";
        //standingFile = firstName.toLowerCase() + lastName.toLowerCase() + "-standing.jpg";
        soundFile = firstName.toLowerCase() + lastName.toLowerCase() + ".wav";
        setImage(portraitFile);
        sitting = true;
    }
    
    //@Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            
            //setImage(standingFile);
            getName();
            sayName(soundFile);
            
            myHobby("I like to run track!");
            flipAnimation();
            resizeAnimation();
            sitDown(); // Returns back to seat after animation
        }
    }
    
    private void flipAnimation() {
        GreenfootImage originalImage = getImage();
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        
        for (int i = 0; i < flipSteps; i++) {
            GreenfootImage rotatedImage = new GreenfootImage(originalImage);
            rotatedImage.rotate(i * 360 / flipSteps);
            setImage(rotatedImage);
            Greenfoot.delay(Delay);
        }
    }
    
    public void getName() {
        System.out.println("My name is " + firstName + " " + lastName);
    }
    
    public void myHobby(String s) {
        System.out.println(s);
    }
    private void resizeAnimation() {
        GreenfootImage originalImage = getImage();
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        
        // Increase size
        for (int i = 0; i < resizeSteps; i++) {
            int newWidth = originalWidth + i * 10;
            int newHeight = originalHeight + i * 10;
            GreenfootImage resizedImage = new GreenfootImage(originalImage);
            resizedImage.scale(newWidth, newHeight);
            setImage(resizedImage);
            Greenfoot.delay(Delay);
        }
        
        // Decrease size
        for (int i = resizeSteps; i > 0; i--) {
            int newWidth = originalWidth + i * 10;
            int newHeight = originalHeight + i * 10;
            GreenfootImage resizedImage = new GreenfootImage(originalImage);
            resizedImage.scale(newWidth, newHeight);
            setImage(resizedImage);
            Greenfoot.delay(Delay);
        }
        
        // Restore original size
        setImage(originalImage);
    }
    // Additional methods for animations or interactions can be added here
}  


