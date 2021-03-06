package com.example.magistr;

<<<<<<< HEAD
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
=======
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
>>>>>>> b804f493298034498739e3e136f8afdbe7232772

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class SpriteSheet extends View {
    private Paint mPaint = new Paint();
    private ArrayList<Bitmap> frames = new ArrayList<Bitmap>();
    private int MAX_WIDTH;
    private int MAX_HEIGHT;
    int sprNumber =0;
    final private Bitmap image;
    final private List<Integer> numbers;

    public SpriteSheet(Context context, Bitmap image, List<Integer> numbers) {
        super(context);
        this.image = image;
        this.numbers = numbers;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //Background Color
        mPaint.setColor(Color.WHITE);
        sprNumber = numbers.size()/6;
        for(int _i=0; _i<sprNumber; _i++) {
            int halfWidth = numbers.get(_i*6+4) - numbers.get(_i*6);
            if((numbers.get(_i*6) - numbers.get(_i*6+2))>halfWidth) {
                halfWidth = numbers.get(_i*6) - numbers.get(_i*6+2);
            }
            int halfHeight = numbers.get(_i*6+5) - numbers.get(_i*6+1);
            if((numbers.get(_i*6+1) - numbers.get(_i*6+3))>halfHeight) {
                halfHeight = numbers.get(_i*6+1) - numbers.get(_i*6+3);
            }
            if(2*halfWidth>MAX_WIDTH) {
                MAX_WIDTH = 2*halfWidth;
            }
            if(2*halfHeight>MAX_HEIGHT) {
                MAX_HEIGHT = 2*halfHeight;
            }
        }
        for(int _i=0; _i<sprNumber; _i++) {
            Bitmap newImage = Bitmap.createBitmap(image, 0, 0, MAX_WIDTH, MAX_HEIGHT);
            Bitmap bi = Bitmap.createBitmap(image, numbers.get(_i*6+2), numbers.get(_i*6+3), numbers.get(_i*6+4), numbers.get(_i*6+5));
            canvas.drawBitmap(bi, MAX_WIDTH/2 - numbers.get(_i*6), MAX_HEIGHT/2 - numbers.get(_i*6+1), mPaint);
            frames.add(newImage);
        }
        for(int _k=3; _k>0; _k--) {
            for(int _i=sprNumber*_k/5; _i<sprNumber*(_k+1)/5; _i++) {
                Bitmap newImage = Bitmap.createBitmap(image, 0, 0, MAX_WIDTH, MAX_HEIGHT);
                Bitmap cropped = Bitmap.createBitmap(frames.get(_i), 0, 0, frames.get(_i).getWidth(), frames.get(_i).getHeight());
                canvas.drawBitmap(cropped, 0+frames.get(_i).getWidth(), 0, mPaint);
                frames.add(newImage);
            }
        }
    }

    public Bitmap grabSprite(int col, int row) {
        int sprRow = sprNumber/5;
        int _n = col*sprRow+row;
        return frames.get(_n);
    }

    public void render(Canvas g, Bitmap frame, int px, int py, boolean selected) {
//		int px = Field.left+x*Field.xSize;
//		int py = Field.top+y*Field.ySize;
        //Graphics2D g2 = (Graphics2D) g;
//        if(selected) {
//            mPaint.setColor(Color.YELLOW);
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            Stroke newStroke = new BasicStroke(2f);
//            g2.setStroke(newStroke );
//            g2.drawOval(px+4, py+4, Field.xSize-8, Field.ySize-8);
//        }
//        g2.drawImage(frame, px-(MAX_WIDTH-Field.xSize)/2, py-MAX_HEIGHT/2+Field.ySize/2, null);
    }
}
=======
public class SpriteSheet {
	private ArrayList<Bitmap> frames = new ArrayList<Bitmap>();
	private int MAX_WIDTH;
	private int MAX_HEIGHT;
	int sprNumber =0;
	public SpriteSheet(Bitmap source, List<Integer> numbers) {
		sprNumber = numbers.size()/6;
		for(int _i=0; _i<sprNumber; _i++) {
			int halfWidth = numbers.get(_i*6+4) - numbers.get(_i*6);
			if((numbers.get(_i*6) - numbers.get(_i*6+2))>halfWidth) {
				halfWidth = numbers.get(_i*6) - numbers.get(_i*6+2);
			}	
			int halfHeight = numbers.get(_i*6+5) - numbers.get(_i*6+1);
			if((numbers.get(_i*6+1) - numbers.get(_i*6+3))>halfHeight) {
				halfHeight = numbers.get(_i*6+1) - numbers.get(_i*6+3);
			}
			if(2*halfWidth>MAX_WIDTH) {
				MAX_WIDTH = 2*halfWidth;
			}
			if(2*halfHeight>MAX_HEIGHT) {
				MAX_HEIGHT = 2*halfHeight;
			}
		}
		for(int _i=0; _i<sprNumber; _i++) {
			Bitmap newImage  = Bitmap.createBitmap(MAX_WIDTH,MAX_HEIGHT, Bitmap.Config.ARGB_8888);
			Bitmap cropped  = Bitmap.createBitmap(source, numbers.get(_i*6+2), numbers.get(_i*6+3), numbers.get(_i*6+4), numbers.get(_i*6+5));
			//BufferedImage bi = image.getSubimage(numbers.get(_i*6+2), numbers.get(_i*6+3), numbers.get(_i*6+4), numbers.get(_i*6+5));
			Canvas canvas = new Canvas(newImage);
			canvas.drawBitmap(cropped,  MAX_WIDTH/2 - numbers.get(_i*6), MAX_HEIGHT/2 - numbers.get(_i*6+1), null );
			frames.add(newImage);
		}
		for(int _k=3; _k>0; _k--) {
			for(int _i=sprNumber*_k/5; _i<sprNumber*(_k+1)/5; _i++) {
				Matrix matrix = new Matrix();
				matrix.preScale(-1.0f,1.0f);
				Bitmap mirrored = Bitmap.createBitmap(frames.get(_i),0,0, MAX_WIDTH, MAX_HEIGHT, matrix, false);
				frames.add(mirrored);
			}
		}
	}

	public Bitmap grabSprite(int col, int row) {
		int sprRow = sprNumber/5;
		int _n = col*sprRow+row;
		return frames.get(_n);
	}

	public void render(Canvas g, Bitmap frame, int px, int py, boolean selected) {
//		int px = Field.left+x*Field.xSize;
//		int py = Field.top+y*Field.ySize;
		Paint mPaint = new Paint();
		mPaint.setColor(Color.RED);
		if(selected) {
			mPaint.setColor(Color.RED);
			mPaint.setStyle(Paint.Style.STROKE);
			mPaint.setStrokeWidth(2);
			//mPaint.setStyle(Paint.Style.);
			g.drawCircle(px+Field.xSize/2, py+Field.ySize/2, (Field.xSize+Field.xSize-4)/4,mPaint);
		}
		g.drawBitmap(frame, px-MAX_WIDTH/2+Field.xSize/2, py-MAX_HEIGHT/2+Field.xSize/2, mPaint);


	}
}
>>>>>>> b804f493298034498739e3e136f8afdbe7232772
