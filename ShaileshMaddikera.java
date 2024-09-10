import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ShaileshMaddikera class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Shailesh Maddikera
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class ShaileshMaddikera extends Student implements SpecialInterestOrHobby
{

    public ShaileshMaddikera(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public ShaileshMaddikera() {
        firstName="Shailesh";
        lastName="Maddikera";
        mySeatX=1;
        mySeatY=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I play the violin, guitar, and piano");
            
                fadeColorOverlayClass();
           
                sitDown();
            }
        
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }

   
    public void fadeColorOverlayClass(){
        GreenfootImage originalImage = getImage();
        GreenfootImage colorOverlay = new GreenfootImage(originalImage.getWidth(), originalImage.getHeight());
    
        int totalSteps = 100;
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        
        for (int i = 0; i <= totalSteps; i++) {
            colorOverlay.clear(); // Clear overlay before each step
            colorOverlay.setColor(new Color(i * 255 / totalSteps, 0, 255 - i * 255 / totalSteps));
            colorOverlay.setTransparency(i * 255 / totalSteps); // Adjust transparency
            colorOverlay.fill(); // Fill the overlay with color
            
            GreenfootImage tempImage = new GreenfootImage(originalImage);
            tempImage.drawImage(colorOverlay, 0, 0);
            
            int rotationAmount = i * 360 / totalSteps; // Rotate 360 degrees over the steps
            tempImage.rotate(rotationAmount);
            
            double scale = 1 + (0.5 * i / totalSteps); // Scale between 1.0 and 1.5
            int newWidth = (int)(originalWidth * scale);
            int newHeight = (int)(originalHeight * scale);
            
            GreenfootImage scaledImage = new GreenfootImage(tempImage);
            
            scaledImage.scale(newWidth, newHeight); // Scale the image
            setImage(scaledImage);
            
            Greenfoot.delay(1); // Delay each step for smooth animation
        }
        
        
        for (int i = totalSteps; i >= 0; i--) {
            colorOverlay.clear(); // Clear overlay before each step
            colorOverlay.setColor(new Color(i * 255 / totalSteps, 0, 255 - i * 255 / totalSteps));
            colorOverlay.setTransparency(i * 255 / totalSteps); // Adjust transparency
            colorOverlay.fill(); // Fill overlay with color
            
            GreenfootImage tempImage = new GreenfootImage(originalImage);
            
            tempImage.drawImage(colorOverlay, 0, 0);
            
            int rotationAmount = i * 360 / totalSteps; // Rotate back to starting position
            tempImage.rotate(rotationAmount);
            
            double scale = 1 + (0.5 * i / totalSteps); // Scale between 1.5 and 1.0
            int newWidth = (int)(originalWidth * scale);
            int newHeight = (int)(originalHeight * scale);
            
            GreenfootImage scaledImage = new GreenfootImage(tempImage);
            scaledImage.scale(newWidth, newHeight); // Scale the image
            
            setImage(scaledImage);
            
            Greenfoot.delay(1); // Delay each step for smooth animation
        }
        
        setImage(originalImage);
    }

    public void myHobby(String s) {
         System.out.println(s);
}

}
