import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image currentImg,LeftImg,RightImg,UpImg,DownImg;
	int x=120,y=120;
	public MainCanvas(){
	try
	{
		DownImg=Image.createImage("/sayo10.png");
		LeftImg=Image.createImage("/sayo12.png");
		RightImg=Image.createImage("/sayo16.png");
		UpImg=Image.createImage("/sayo14.png");
		currentImg=DownImg;
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	 }
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	if(action==LEFT){
		currentImg=LeftImg;
		x=x-3;
		System.out.println("向左走");
	}
	else if(action==RIGHT){
currentImg=RightImg;
x=x+3;
System.out.println("向右走");
	}
	else if(action==UP){
		currentImg=UpImg;
		y=y-3;
	System.out.println("向上走");
	}
	else if (action==DOWN){
		currentImg=DownImg;
		y=y+3;
	System.out.println("向下走");
	}
	repaint();
	}
}