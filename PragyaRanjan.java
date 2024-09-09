import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PragyaRanjan class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class PragyaRanjan extends Student implements SpecialInterestOrHobby
{
    
    
   
    public PragyaRanjan(String f, String l, int r, int s) {
        firstName = f;
        lastName = l;
        mySeatX = r;
        mySeatY = s;
        portraitFile = f.toLowerCase() + l.toLowerCase() + ".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile = firstName.toLowerCase() + lastName.toLowerCase() + "-standing.jpg";
        soundFile = f.toLowerCase() + l.toLowerCase() + ".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        
        // Set the image without resizing
        setImage(portraitFile); 
        
        sitting = true;
        
    }

    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public PragyaRanjan() {
        firstName="Pragya";
        lastName="Ranjan";
        mySeatX=9;
        mySeatY=10;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
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
            myHobby("I like to read!");

            blinkClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
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
     * This is a local method specific to the CopyOfPragyaRanjan class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void blinkClass() {
    // Store the original seat position
    int startX = getX();
    int startY = getY();
    
    // Define three blink positions
    int[][] blinkPositions = {
        {startX - 50, startY - 50},
        {startX + 20, startY - 50},
        {startX-20, startY-10},
        {startX, startY + 50}
    };
    
    // Move to each position with a brief pause
    for (int[] position : blinkPositions) {
        setLocation(position[0], position[1]);
        Greenfoot.delay(15); // Delay to create the "blink" effect
    }
    
    Greenfoot.delay(20); // Additional pause before returning to seat
    sitDown();// Return to the original seat
    sayName(soundFile); 
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
}
