import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Stroke;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class Customer
{
    int pos_x;  
    int pos_y;  
    JPanel canvas;  

    int width;
	int height;
	
	 int order;
	 int type1;
	 int type2;
    
    // 更新文字位置水平移動speed像素
    public void updatePos(int speed,int order,int type1,int type2)
    {
    	
       
    	
    		if(pos_x >=150 && pos_x<=300) {
    			if(order==0 && pos_x==150) {
    				pos_x = 150;}
    			else if(type1==0 && type2==0 && pos_x==225) {
    				pos_x = 225;}
    			else {
    				pos_x = pos_x+(4*order+4*type1+9*type2)/(17*5);}
    		}else
    			pos_x += speed;
    }
    
   
    public void draw(Graphics g)
    {
    
       
    	
        g.fillOval(pos_x, pos_y, 20,20);  
    }
    
    
    public Customer(int x, int y, JPanel c,int order,int type1,int type2)
    { 
        pos_x = x;
        pos_y = y;
        canvas = c;
        width = canvas.getWidth();
        height = canvas.getHeight();
        this.order=order;
        this.type1=type1;
        this.type2=type2;
    }
}




class Data
{
	
    int begin_x=0;
    int begin_y=0;  

   
    public Data(int x, int y)
    { 
    	begin_x=x;
    	begin_y=y;
    		
    }
}




class TextMarquee extends JPanel 
{
	int FIELD_WIDTH = 10;
	JLabel label1;
	JLabel label2;
	JLabel business_label = new JLabel("Business hour:");
	JPanel radio; 
	ArrayList<Customer> custList;
	ArrayList<Data> dataList;
	
    JLabel rate_label = new JLabel("Simulate speed:");
    JSlider slider1;
    
    JLabel arrival_label = new JLabel("Arrival rate (per hour):");
    JSlider slider2;
    
    JLabel order_label = new JLabel("Service rate of order (per hour):");
    JSlider slider3;// 滑軸 
    
    JLabel type1_label = new JLabel("Service rate of making Type1 (per hour):");
    JSlider slider4;// 滑軸 
    
    JLabel type2_label = new JLabel("Service rate of making Type2 (per hour):");
    JSlider slider5;// 滑軸 
    
	
	JPanel canvas;   // 畫布
	JPanel data;
    Thread timer;  // 緒，當計時器用
    int speed; // 文字單位時間水平移動量
    Customer text; // 文字物件
    JPanel panel;
    JPanel leftPanel;
    int arrival;
    int order;
    int type1;
    int type2;
    int j = 0;
    
    public void genCust(int num) {
    	Customer cust;
    	
    	for(int i=0;i<num;i++) {
    		cust = new Customer(0,90,TextMarquee.this,order,type1,type2);
    		custList.add(cust);
    	
    	}	
    }
    
    public void genData(int num) {
    		Data data;
    		data = new Data(j,num);
    		dataList.add(data);
    		j+=1;
    	}	
    
    
    
    
    public TextMarquee() 
    {
    	
    	custList = new ArrayList<Customer>();

        slider1 = new JSlider(SwingConstants.HORIZONTAL, 10, 50, 25);
        slider2 = new JSlider(SwingConstants.HORIZONTAL, 10, 50, 25);
        slider3 = new JSlider(SwingConstants.HORIZONTAL, 10, 50, 25);
        slider4 = new JSlider(SwingConstants.HORIZONTAL, 10, 50, 25);
        slider5 = new JSlider(SwingConstants.HORIZONTAL, 10, 50, 25);
        
        slider1.setMajorTickSpacing(10);
    	slider1.setPaintTicks(true);
    	slider1.setPaintLabels(true);
    	
    	slider2.setMajorTickSpacing(10);
    	slider2.setPaintTicks(true);
    	slider2.setPaintLabels(true);
    	
    	slider3.setMajorTickSpacing(10);
    	slider3.setPaintTicks(true);
    	slider3.setPaintLabels(true);
    	
    	slider4.setMajorTickSpacing(10);
    	slider4.setPaintTicks(true);
    	slider4.setPaintLabels(true);
    	
    	slider5.setMajorTickSpacing(10);
    	slider5.setPaintTicks(true);
    	slider5.setPaintLabels(true);
        

        ChangeListener change1 = new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
            	speed = slider1.getValue();
             }
        };
        slider1.addChangeListener(change1);
        speed = slider1.getValue();
        
        
        ChangeListener arrivalChange = new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
            	arrival = slider2.getValue();
             }
        };
        slider2.addChangeListener(arrivalChange);
        arrival = slider2.getValue();
        
        
        ChangeListener orderChange = new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
            	order = slider3.getValue();
             }
        };
        slider3.addChangeListener(orderChange);
        order = slider3.getValue();
        
        
        ChangeListener type1Change = new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
            	type1 = slider4.getValue();
             }
        };
        slider4.addChangeListener(type1Change);
        type1 = slider4.getValue();
        
        
        ChangeListener type2Change = new ChangeListener()
        {
            public void stateChanged(ChangeEvent ce)
            {
            	type2 = slider5.getValue();
             }
        };
        slider5.addChangeListener(type2Change);
        type2 = slider5.getValue();
        
        

 
           

//-------------------------------------------------------------------------------------------
       dataList = new ArrayList<Data>();
        
        data = new JPanel() 
        {
            @Override
            public void paintComponent(Graphics g) 
            {
               super.paintComponent(g);
               g.setColor(Color.WHITE);
               g.drawString("Ws(m)", 10, 20);
             
               
               if(dataList.size()>=2) { 
            	   for(int z=0;z<dataList.size()-1;z++) {
            	   		g.setColor(Color.GREEN);	
            	   		g.drawLine(dataList.get(z).begin_x, dataList.get(z).begin_y, dataList.get(z+1).begin_x, dataList.get(z+1).begin_y);
            	   		} 
            	   	}	
               
                
            }
        };
           
        data.setBackground(Color.GRAY);
        
        timer.start();        
        
        label1 = new JLabel("Copy right for G1");

        
        this.setLayout(new GridLayout(1,2));  
        
        leftPanel = new JPanel(new GridLayout(2,1));

        leftPanel.add(canvas);
        leftPanel.add(data);
        
        panel = new JPanel(new GridLayout(5,2));
        panel.add(rate_label); 
        panel.add(slider1);
        panel.add(arrival_label); 
        panel.add(slider2);
        panel.add(order_label); 
        panel.add(slider3); 
        panel.add(type1_label); 
        panel.add(slider4); 
        panel.add(type2_label); 
        panel.add(slider5); 
        
        this.setLayout(new BorderLayout());
        this.add(leftPanel,BorderLayout.CENTER);
        this.add(label1,BorderLayout.NORTH);
        this.add(panel,BorderLayout.WEST); 
        
    }
}


public class panel {

    public static void main(String args[]) {
        JFrame jframe = new JFrame();
        TextMarquee marquee = new TextMarquee();
        
        jframe.add(marquee, BorderLayout.CENTER);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(900, 400);

        jframe.setVisible(true);
    }
}
