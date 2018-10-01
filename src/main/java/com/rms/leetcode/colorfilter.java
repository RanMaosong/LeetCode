package com.rms.leetcode;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class colorfilter extends Frame{
    Image im, tmp;
    int i, iw, ih;
    int[] pixels;
    boolean flag_load = false;

    public colorfilter(){
        this.setTitle("彩色图像均值中值滤波");
        Panel pdown;
        Button load, addSaltAndPepperNoise, median, medianfive;
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        pdown = new Panel();
        pdown.setBackground(Color.lightGray);
        //定义按钮
        load = new Button("装载图像");
        addSaltAndPepperNoise = new Button("添加椒盐噪声");
        median = new Button("中值滤波3*3");
        medianfive = new Button("中值滤波5*5");

        this.add(pdown, BorderLayout.SOUTH);
        //添加按钮
        pdown.add(load);
        pdown.add(addSaltAndPepperNoise);
        pdown.add(median);
        pdown.add(medianfive);
        //按钮的动作程序  装载图像
        load.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    jLoad_ActionPerformed(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //按钮的动作程序 添加椒盐噪声
        addSaltAndPepperNoise.addActionListener(new ActionListener() {
//            @Override
            public void actionPerformed(ActionEvent e) {
                jAddSaltAndPepperNoise(e);
            }
        });
        //按钮的动作程序  中值滤波3*3
        median.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jMedian_ActionPerformed(e);
            }
        });
        //按钮的动作程序  中值滤波5*5
        medianfive.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jMedianfive_ActionPerformed(e);
            }
        });


    }
    //按钮动作的实现  加载图像
    public void jLoad_ActionPerformed(ActionEvent e) throws IOException{
        File inputFile = new File("/Users/xinrenwo/Desktop/lenna.bmp");
        BufferedImage input = ImageIO.read(inputFile);
        iw = input.getWidth(this);
        ih = input.getHeight(this);
        pixels = new int[iw*ih];
        im = input;
        tmp = input;
        flag_load = true;
        repaint();
    }


    //按钮动作的实现 添加椒盐噪声
    public void jAddSaltAndPepperNoise(ActionEvent e) {
        if(flag_load) {
            try{
                PixelGrabber pg = new PixelGrabber(im,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch(InterruptedException e3){
                e3.printStackTrace();
            }
            BufferedImage grayImage = new BufferedImage(iw, ih,
                    BufferedImage.TYPE_INT_RGB);

            ColorModel cm = ColorModel.getRGBdefault();

            int size =(int) (pixels.length * 0.08);
            for(int i=0; i<size; i++) {
                int row = (int)(Math.random() * (double)ih);
                int col = (int)(Math.random() * (double)iw);
                pixels[row * iw + col] = (255 << 24) | (255 << 16) | (255 << 8) | 255;
            }
            grayImage.setRGB(0,0,iw,ih,pixels,0,iw);
            tmp = grayImage;
            repaint();
        }else{
            JOptionPane.showMessageDialog(null, "先点击“装载图像”，3Q！","提示：",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    //按钮动作的实现 中值滤波3*3
    public void jMedian_ActionPerformed(ActionEvent e) {
        if(flag_load){
            try{
                PixelGrabber pg = new PixelGrabber(tmp,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch(InterruptedException e3){
                e3.printStackTrace();
            }
            BufferedImage grayImage = new BufferedImage(iw, ih,
                    BufferedImage.TYPE_INT_RGB);

            ColorModel cm = ColorModel.getRGBdefault();

            int[] tpRed = new int[9];
            int[] tpGreen = new int[9];
            int[] tpBlue = new int[9];

            for(int i=1;i<ih-1;i++){
                for(int j=1;j<iw-1;j++){

                    tpRed[0] = cm.getRed(pixels[(i-1)*iw+j-1]);
                    tpRed[1] = cm.getRed(pixels[(i-1)*iw+j]);
                    tpRed[2] = cm.getRed(pixels[(i-1)*iw+j+1]);
                    tpRed[3] = cm.getRed(pixels[i*iw+j-1]);
                    tpRed[4] = cm.getRed(pixels[i*iw+j]);
                    tpRed[5] = cm.getRed(pixels[i*iw+j+1]);
                    tpRed[6] = cm.getRed(pixels[(i+1)*iw+j-1]);
                    tpRed[7] = cm.getRed(pixels[(i+1)*iw+j]);
                    tpRed[8] = cm.getRed(pixels[(i+1)*iw+j+1]);
                    for(int rj=0; rj<8; rj++){
                        for(int ri=0; ri<8-rj; ri++){
                            if(tpRed[ri]>tpRed[ri+1]){
                                int Red_Temp = tpRed[ri];
                                tpRed[ri] = tpRed[ri+1];
                                tpRed[ri+1] = Red_Temp;
                            }
                        }
                    }
                    int medianRed = tpRed[4];

                    tpGreen[0] = cm.getGreen(pixels[(i-1)*iw+j-1]);
                    tpGreen[1] = cm.getGreen(pixels[(i-1)*iw+j]);
                    tpGreen[2] = cm.getGreen(pixels[(i-1)*iw+j+1]);
                    tpGreen[3] = cm.getGreen(pixels[i*iw+j-1]);
                    tpGreen[4] = cm.getGreen(pixels[i*iw+j]);
                    tpGreen[5] = cm.getGreen(pixels[i*iw+j+1]);
                    tpGreen[6] = cm.getGreen(pixels[(i+1)*iw+j-1]);
                    tpGreen[7] = cm.getGreen(pixels[(i+1)*iw+j]);
                    tpGreen[8] = cm.getGreen(pixels[(i+1)*iw+j+1]);
                    for(int rj=0; rj<8; rj++){
                        for(int ri=0; ri<8-rj; ri++){
                            if(tpGreen[ri]>tpGreen[ri+1]){
                                int Green_Temp = tpGreen[ri];
                                tpGreen[ri] = tpGreen[ri+1];
                                tpGreen[ri+1] = Green_Temp;
                            }
                        }
                    }
                    int medianGreen = tpGreen[4];

                    tpBlue[0] = cm.getBlue(pixels[(i-1)*iw+j-1]);
                    tpBlue[1] = cm.getBlue(pixels[(i-1)*iw+j]);
                    tpBlue[2] = cm.getBlue(pixels[(i-1)*iw+j+1]);
                    tpBlue[3] = cm.getBlue(pixels[i*iw+j-1]);
                    tpBlue[4] = cm.getBlue(pixels[i*iw+j]);
                    tpBlue[5] = cm.getBlue(pixels[i*iw+j+1]);
                    tpBlue[6] = cm.getBlue(pixels[(i+1)*iw+j-1]);
                    tpBlue[7] = cm.getBlue(pixels[(i+1)*iw+j]);
                    tpBlue[8] = cm.getBlue(pixels[(i+1)*iw+j+1]);
                    for(int rj=0; rj<8; rj++){
                        for(int ri=0; ri<8-rj; ri++){
                            if(tpBlue[ri]>tpBlue[ri+1]){
                                int Blue_Temp = tpBlue[ri];
                                tpBlue[ri] = tpBlue[ri+1];
                                tpBlue[ri+1] = Blue_Temp;
                            }
                        }
                    }
                    int medianBlue = tpBlue[4];

                    int rgb = 255<<24|medianRed<<16|medianGreen<<8|medianBlue;
                    grayImage.setRGB(j, i, rgb);
                }
            }
            tmp = grayImage;
            repaint();

        }else{
            JOptionPane.showMessageDialog(null, "先点击“装载图像”，3Q！","提示：",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    //按钮动作实现 中值滤波5*5
    public void jMedianfive_ActionPerformed(ActionEvent e) {
        if(flag_load){
            try{
                PixelGrabber pg = new PixelGrabber(tmp,0,0,iw,ih,pixels,0,iw);
                pg.grabPixels();
            }catch(InterruptedException e3){
                e3.printStackTrace();
            }
            BufferedImage grayImage = new BufferedImage(iw, ih,
                    BufferedImage.TYPE_INT_RGB);

            ColorModel cm = ColorModel.getRGBdefault();

            int[] tpRed = new int[25];
            int[] tpGreen = new int[25];
            int[] tpBlue = new int[25];

            for(int i=2;i<ih-2;i++){
                for(int j=2;j<iw-2;j++){

                    tpRed[0] = cm.getRed(pixels[(i-2)*iw+j-2]);
                    tpRed[1] = cm.getRed(pixels[(i-2)*iw+j-1]);
                    tpRed[2] = cm.getRed(pixels[(i-2)*iw+j]);
                    tpRed[3] = cm.getRed(pixels[(i-2)*iw+j+1]);
                    tpRed[4] = cm.getRed(pixels[(i-2)*iw+j+2]);
                    tpRed[5] = cm.getRed(pixels[(i-1)*iw+j-2]);
                    tpRed[6] = cm.getRed(pixels[(i-1)*iw+j-1]);
                    tpRed[7] = cm.getRed(pixels[(i-1)*iw+j]);
                    tpRed[8] = cm.getRed(pixels[(i-1)*iw+j+1]);
                    tpRed[9] = cm.getRed(pixels[(i-1)*iw+j+2]);
                    tpRed[10] = cm.getRed(pixels[i*iw+j-2]);
                    tpRed[11] = cm.getRed(pixels[i*iw+j-1]);
                    tpRed[12] = cm.getRed(pixels[i*iw+j]);
                    tpRed[13] = cm.getRed(pixels[i*iw+j+1]);
                    tpRed[14] = cm.getRed(pixels[i*iw+j+2]);
                    tpRed[15] = cm.getRed(pixels[(i+1)*iw+j-2]);
                    tpRed[16] = cm.getRed(pixels[(i+1)*iw+j-1]);
                    tpRed[17] = cm.getRed(pixels[(i+1)*iw+j]);
                    tpRed[18] = cm.getRed(pixels[(i+1)*iw+j+1]);
                    tpRed[19] = cm.getRed(pixels[(i+1)*iw+j+2]);
                    tpRed[20] = cm.getRed(pixels[(i+2)*iw+j-2]);
                    tpRed[21] = cm.getRed(pixels[(i+2)*iw+j-1]);
                    tpRed[22] = cm.getRed(pixels[(i+2)*iw+j]);
                    tpRed[23] = cm.getRed(pixels[(i+2)*iw+j+1]);
                    tpRed[24] = cm.getRed(pixels[(i+2)*iw+j+2]);
                    for(int rj=0; rj<24; rj++){
                        for(int ri=0; ri<24-rj; ri++){
                            if(tpRed[ri]>tpRed[ri+1]){
                                int Red_Temp = tpRed[ri];
                                tpRed[ri] = tpRed[ri+1];
                                tpRed[ri+1] = Red_Temp;
                            }
                        }
                    }
                    int medianRed = tpRed[12];


                    tpGreen[0] = cm.getGreen(pixels[(i-2)*iw+j-2]);
                    tpGreen[1] = cm.getGreen(pixels[(i-2)*iw+j-1]);
                    tpGreen[2] = cm.getGreen(pixels[(i-2)*iw+j]);
                    tpGreen[3] = cm.getGreen(pixels[(i-2)*iw+j+1]);
                    tpGreen[4] = cm.getGreen(pixels[(i-2)*iw+j+2]);
                    tpGreen[5] = cm.getGreen(pixels[(i-1)*iw+j-2]);
                    tpGreen[6] = cm.getGreen(pixels[(i-1)*iw+j-1]);
                    tpGreen[7] = cm.getGreen(pixels[(i-1)*iw+j]);
                    tpGreen[8] = cm.getGreen(pixels[(i-1)*iw+j+1]);
                    tpGreen[9] = cm.getGreen(pixels[(i-1)*iw+j+2]);
                    tpGreen[10] = cm.getGreen(pixels[i*iw+j-2]);
                    tpGreen[11] = cm.getGreen(pixels[i*iw+j-1]);
                    tpGreen[12] = cm.getGreen(pixels[i*iw+j]);
                    tpGreen[13] = cm.getGreen(pixels[i*iw+j+1]);
                    tpGreen[14] = cm.getGreen(pixels[i*iw+j+2]);
                    tpGreen[15] = cm.getGreen(pixels[(i+1)*iw+j-2]);
                    tpGreen[16] = cm.getGreen(pixels[(i+1)*iw+j-1]);
                    tpGreen[17] = cm.getGreen(pixels[(i+1)*iw+j]);
                    tpGreen[18] = cm.getGreen(pixels[(i+1)*iw+j+1]);
                    tpGreen[19] = cm.getGreen(pixels[(i+1)*iw+j+2]);
                    tpGreen[20] = cm.getGreen(pixels[(i+2)*iw+j-2]);
                    tpGreen[21] = cm.getGreen(pixels[(i+2)*iw+j-1]);
                    tpGreen[22] = cm.getGreen(pixels[(i+2)*iw+j]);
                    tpGreen[23] = cm.getGreen(pixels[(i+2)*iw+j+1]);
                    tpGreen[24] = cm.getGreen(pixels[(i+2)*iw+j+2]);
                    for(int rj=0; rj<24; rj++){
                        for(int ri=0; ri<24-rj; ri++){
                            if(tpGreen[ri]>tpGreen[ri+1]){
                                int Green_Temp = tpGreen[ri];
                                tpGreen[ri] = tpGreen[ri+1];
                                tpGreen[ri+1] = Green_Temp;
                            }
                        }
                    }
                    int medianGreen = tpGreen[12];

                    tpBlue[0] = cm.getBlue(pixels[(i-2)*iw+j-2]);
                    tpBlue[1] = cm.getBlue(pixels[(i-2)*iw+j-1]);
                    tpBlue[2] = cm.getBlue(pixels[(i-2)*iw+j]);
                    tpBlue[3] = cm.getBlue(pixels[(i-2)*iw+j+1]);
                    tpBlue[4] = cm.getBlue(pixels[(i-2)*iw+j+2]);
                    tpBlue[5] = cm.getBlue(pixels[(i-1)*iw+j-2]);
                    tpBlue[6] = cm.getBlue(pixels[(i-1)*iw+j-1]);
                    tpBlue[7] = cm.getBlue(pixels[(i-1)*iw+j]);
                    tpBlue[8] = cm.getBlue(pixels[(i-1)*iw+j+1]);
                    tpBlue[9] = cm.getBlue(pixels[(i-1)*iw+j+2]);
                    tpBlue[10] = cm.getBlue(pixels[i*iw+j-2]);
                    tpBlue[11] = cm.getBlue(pixels[i*iw+j-1]);
                    tpBlue[12] = cm.getBlue(pixels[i*iw+j]);
                    tpBlue[13] = cm.getBlue(pixels[i*iw+j+1]);
                    tpBlue[14] = cm.getBlue(pixels[i*iw+j+2]);
                    tpBlue[15] = cm.getBlue(pixels[(i+1)*iw+j-2]);
                    tpBlue[16] = cm.getBlue(pixels[(i+1)*iw+j-1]);
                    tpBlue[17] = cm.getBlue(pixels[(i+1)*iw+j]);
                    tpBlue[18] = cm.getBlue(pixels[(i+1)*iw+j+1]);
                    tpBlue[19] = cm.getBlue(pixels[(i+1)*iw+j+2]);
                    tpBlue[20] = cm.getBlue(pixels[(i+2)*iw+j-2]);
                    tpBlue[21] = cm.getBlue(pixels[(i+2)*iw+j-1]);
                    tpBlue[22] = cm.getBlue(pixels[(i+2)*iw+j]);
                    tpBlue[23] = cm.getBlue(pixels[(i+2)*iw+j+1]);
                    tpBlue[24] = cm.getBlue(pixels[(i+2)*iw+j+2]);
                    for(int rj=0; rj<24; rj++){
                        for(int ri=0; ri<24-rj; ri++){
                            if(tpBlue[ri]>tpBlue[ri+1]){
                                int Blue_Temp = tpBlue[ri];
                                tpBlue[ri] = tpBlue[ri+1];
                                tpBlue[ri+1] = Blue_Temp;
                            }
                        }
                    }
                    int medianBlue = tpBlue[12];

                    int rgb = 255<<24|medianRed<<16|medianGreen<<8|medianBlue;
                    grayImage.setRGB(j, i, rgb);
                }
            }
            tmp = grayImage;
            repaint();

        }else{
            JOptionPane.showMessageDialog(null, "先点击“装载图像”，3Q！","提示：",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    //按钮动作的实现  退出
    public void jQuit_ActionPerformed(ActionEvent e){
        System.exit(0);
    }
    //绘图函数
    public void paint(Graphics g){
        if(flag_load){
            g.drawImage(tmp,50,50,this);
        }else{}
    }

    public static void main(String[] args) {
        colorfilter ti = new colorfilter();
        ti.setSize(1000,860);
        ti.setVisible(true);
    }
}