package entity;

/**
 * Created by user on 03/07/2016.
 */
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
public class IsoHelper {
        /**
         * convert an isometric point to 2D
         * */
    public static Point isoTo2D(Point pt){
        Point tempPt=new Point(0,0);
        tempPt.x=(2*pt.y+pt.x)/2;
        tempPt.y=(2*pt.y-pt.x)/2;
        return tempPt;
    }
        /**
         * convert a 2d point to isometric
         * */
    public static Point twoDToIso(Point pt){
        Point tempPt=new Point(0,0);
        tempPt.x=pt.x-pt.y;
        tempPt.y=(pt.x+pt.y)/2;
        return tempPt;
    }

    /**
     * convert a 2d point to specific tile row/column
     * */
    public static Point getTileCoordinates(Point pt, int tileHeight){
        Point tempPt=new Point(0,0);
        tempPt.x = pt.x/tileHeight;//Math.floor(pt.x/tileHeight);
        tempPt.y = pt.y/tileHeight; //Math.floor(pt.y/tileHeight);
        return tempPt;
    }

    /**
     * convert specific tile row/column to 2d point
     * */
    public static Point get2dFromTileCoordinates(Point pt, int tileHeight){
        Point tempPt=new Point(0,0);
        tempPt.x=pt.x*tileHeight;
        tempPt.y=pt.y*tileHeight;

        return tempPt;
    }

//    var levelData=[[1,1,1,1,1,1],
//            [1,0,0,2,0,1],
//            [1,0,1,0,0,1],
//            [1,0,0,0,0,1],
//            [1,0,0,0,0,1],
//            [1,1,1,1,1,1]];
//
//    var tileWidth:uint = 50;
//    var borderOffsetY:uint = 70;
//    var borderOffsetX:uint = 275;
//
//    var facing:String = "south";
//    var currentFacing:String = "south";
//    var hero:MovieClip=new herotile();
//    hero.clip.gotoAndStop(facing);
//    var heroPointer:Sprite;
//    var key:KeyObject = new KeyObject(stage);//Senocular KeyObject Class
//    var heroHalfSize:uint=20;
//
//    //the tiles
//    var grassTile:MovieClip=new TileMc();
//    grassTile.gotoAndStop(1);
//    var wallTile:MovieClip=new TileMc();
//    wallTile.gotoAndStop(2);
//
//    //the canvas

//    Bitmap bg = Bitmap.createBitmap(650, 450, Bitmap.Config.ARGB_8888);//new Bitmap(new BitmapData(650,450));
//    //addChild(bg);
//    Rectangle rect=bg.bitmapData.rect;

//
//    //to handle depth
//    var overlayContainer:Sprite=new Sprite();
//    addChild(overlayContainer);

    //sort depth & draw to canvas
//    function depthSort()
//    {
//        bg.bitmapData.lock();
//        bg.bitmapData.fillRect(rect,0xffffff);
//        var tileType:uint;
//        var mat:Matrix=new Matrix();
//        var pos:Point=new Point();
//        for (var i:uint=0; i<levelData.length; i++)
//        {
//            for (var j:uint=0; j<levelData[0].length; j++)
//            {
//                tileType = levelData[i][j];
//                //placeTile(tileType,i,j);
//
//                pos.x = j * tileWidth;
//                pos.y = i * tileWidth;
//                pos = IsoHelper.twoDToIso(pos);
//                mat.tx = borderOffsetX + pos.x;
//                mat.ty = borderOffsetY + pos.y;
//                if(tileType==0){
//                    bg.bitmapData.draw(grassTile,mat);
//                }else{
//                    bg.bitmapData.draw(wallTile,mat);
//                }
//                if(heroTile.x==j&&heroTile.y==i){
//                    mat.tx=hero.x;
//                    mat.ty=hero.y;
//                    bg.bitmapData.draw(hero,mat);
//                }
//
//            }
//        }
//        bg.bitmapData.unlock();
//add character rectangle
    //}
}
