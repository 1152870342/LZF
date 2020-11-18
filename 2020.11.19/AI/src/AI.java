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
{   Image heroLeftImg[]
	Image currentImg,LeftImg,RightImg,UpImg,DownImg;
	Image LeftImg01,LeftImg02,RightImg01,RightImg02,UpImg01,UpImg02,DownImg01,DownImg02;
	int x,y;
	int Leftflag,Rightflag,Upflag,Downflag;
	public MainCanvas(){
	try
	{
		for(i=0,)
		DownImg=Image.createImage("/sayo10.png");
		DownImg01=Image.createImage("/sayo00.png");
		DownImg02=Image.createImage("/sayo20.png");

		LeftImg=Image.createImage("/sayo12.png");
		LeftImg01=Image.createImage("/sayo02.png");
		LeftImg02=Image.createImage("/sayo22.png");

		RightImg=Image.createImage("/sayo16.png");
		RightImg01=Image.createImage("/sayo06.png");
		RightImg02=Image.createImage("/sayo26.png");

		UpImg=Image.createImage("/sayo14.png");
		UpImg01=Image.createImage("/sayo04.png");
		UpImg02=Image.createImage("/sayo24.png");
	
		currentImg=DownImg;
		x=120;
		y=120;
		Leftflag=1;
		Rightflag=1;
		Upflag=1;
		Downflag=1;
		
		
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
		if(Leftflag==1){
			currentImg=LeftImg01;
			Leftflag++;
		}
		else if(Leftflag==2){
			currentImg=LeftImg02;
			Leftflag=1;
		}
			System.out.println("向左走");
				x=x-3;
	}
	
	else if(action==RIGHT){
		if(Rightflag==1){
			currentImg=RightImg01;
			Rightflag++;
		}
		else if(Rightflag==2){
			currentImg=RightImg02;
			Rightflag=1;
		}
System.out.println("向右走");
		x=x+3;
	}
	
	else if(action==UP){
	if(Upflag==1){
		currentImg=UpImg01;	
		Upflag++;
	}
		else if(Upflag==2){
			currentImg=UpImg02;
			Upflag=1;
		}
	System.out.println("向上走");
			y=y-3;
	}
	else if (action==DOWN){
		if(Downflag==1){
			currentImg=DownImg01;
			Downflag++;	
	    }
		else if(Downflag==2){
			currentImg=DownImg02;
			Downflag=1;
		System.out.println("向下走");
	     }
		y=y+3;
    }   	
	repaint();
  }	
}