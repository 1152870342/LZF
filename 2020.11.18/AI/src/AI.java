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
	Image LeftImg01,LeftImg02,RightImg01,RightImg02,UpImg01,UpImg02,DownImg01,DownImg02;
	int x,y,i;
	public MainCanvas(){
	try
	{
		DownImg=Image.createImage("/sayo10.png");
		LeftImg=Image.createImage("/sayo12.png");
		RightImg=Image.createImage("/sayo16.png");
		UpImg=Image.createImage("/sayo14.png");
        LeftImg01=Image.createImage("/sayo02.png");
		LeftImg02=Image.createImage("/sayo22.png");
		RightImg01=Image.createImage("/sayo06.png");
		RightImg02=Image.createImage("/sayo26.png");
		UpImg01=Image.createImage("/sayo04.png");
		UpImg02=Image.createImage("/sayo24.png");
		DownImg01=Image.createImage("/sayo00.png");
		DownImg02=Image.createImage("/sayo20.png");
		currentImg=DownImg;
		x=120;
		y=120;
		i=0;  
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	 }
	}
	public void paint(Graphics g){
		g.setColor(0,100,100);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);      
	if(action==LEFT){
		if(i==0){
		currentImg=LeftImg;
		System.out.println("向左走");
	}
	else if(i==1){
	currentImg=LeftImg01;
	x=x-3;
	}
	else if(i==2){
	currentImg=LeftImg02;
	x=x-3;
	}
	action=action;
	}
	else if(action==RIGHT){
		if(i==0){
currentImg=RightImg;		
System.out.println("向右走");
		}
		else if(i==1){
		currentImg=RightImg01;
		x=x+3;
		}
		else if(i==2){
		currentImg=RightImg02;
		x=x+3;
		}
	}
	else if(action==UP){
		if(i==0){
		currentImg=UpImg;		
	System.out.println("向上走");
		}
		else if(i==1){
			currentImg=UpImg01;
			y=y-3;
		}
		else if(i==2){
		currentImg=UpImg02;
			y=y-3;
		}
	}
	else if (action==DOWN){
		if(i==0){
		currentImg=DownImg;
	System.out.println("向下走");
	}
else if(i==1){
currentImg=DownImg01;
y=y+3;
}
else if(i==2){
currentImg=DownImg02;
y=y+3;
}
	}
	repaint();
	if(i==0)
		i=1;
		else if(i==1)
			i=2;
		else if(i==2)
			i=1;
	}
}