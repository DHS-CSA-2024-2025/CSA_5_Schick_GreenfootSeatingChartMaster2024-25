import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PragyaRanjan class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class PragyaRanjan extends Student implements SpecialInterestOrHobby
{
    private String firstName;
    private String lastName;
    private int mySeatX;
    private int mySeatY;
    private String portraitFile;
    private String standingFile;
    private String soundFile;
    private boolean sitting;
    
    /**
     * Constructor for the PragyaRanjan class.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     */
    public PragyaRanjan(String f, String l, int r, int s) {
        firstName = f;
        lastName = l;
        mySeatX = r;
        mySeatY = s;
        portraitFile = f.toLowerCase() + l.toLowerCase() + ".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile = firstName.toLowerCase() + lastName.toLowerCase() + "-standing.jpg";
        soundFile = f.toLowerCase() + l.toLowerCase() + ".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        
        GreenfootImage originalImage = new GreenfootImage(portraitFile);
        GreenfootImage resizedImage = resizeImage(originalImage, 100, 200); // Resize to 100x200 pixels
        setImage(resizedImage);
        
        sitting = true;
        
        // Set the initial position to the seat location
        setLocation(mySeatX, mySeatY);
    }

    /**
     * Default constructor, if you don't pass in a name and seating location
     */
    public PragyaRanjan() {
        this("Pragya", "Ranjan", 1, 1);
    }
    
    /**
     * Act - do whatever the PragyaRanjan actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            sitting = false;
            setImage(standingFile);
            System.out.println(""); // Print a blank line to create space between any student output.
            getName();
            sayName(soundFile);
            myHobby("I like to time travel!");

            circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            sitDown();
        }
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }

    /**
     * This is a local method specific to the PragyaRanjan class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        // Store the initial position
        int startX = getX();
        int startY = getY();
        
        // Move in a circle around the seat location
        for (int angle = 0; angle < 360; angle += 15) {
            int radius = 50;  // Radius of the circular path
            int x = startX + (int)(radius * Math.cos(Math.toRadians(angle)));
            int y = startY + (int)(radius * Math.sin(Math.toRadians(angle)));
            setLocation(x, y);
            Greenfoot.delay(10);
        }
        
        Greenfoot.delay(20);
        returnToSeat();
    }

    /**
     * Returns the actor to the original seat position
     */
    public void returnToSeat() {
        setLocation(mySeatX, mySeatY);
    }

    /**
     * Prints the hobby or special interest to the console.
     * @param s A string representing the hobby or special interest.
     */
    public void myHobby(String s) {
        System.out.println(s);
    }

    /**
     * Resizes a GreenfootImage to the specified width and height while maintaining the aspect ratio.
     * @param originalImage The original GreenfootImage to resize.
     * @param width The desired width of the new image.
     * @param height The desired height of the new image.
     * @return A new GreenfootImage that is resized to the specified width and height while maintaining the aspect ratio.
     */
    private GreenfootImage resizeImage(GreenfootImage originalImage, int width, int height) {
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        // Calculate the new dimensions maintaining the aspect ratio
        double aspectRatio = (double) originalWidth / originalHeight;
        int newWidth, newHeight;

        if (width / (double) height > aspectRatio) {
            newWidth = (int) (height * aspectRatio);
            newHeight = height;
        } else {
            newWidth = width;
            newHeight = (int) (width / aspectRatio);
        }

        GreenfootImage newImage = new GreenfootImage(newWidth, newHeight);
        newImage.drawImage(originalImage, 0, 0);
        newImage.scale(newWidth, newHeight);  // Scale the new image to the calculated dimensions
        return newImage;
    }
}
