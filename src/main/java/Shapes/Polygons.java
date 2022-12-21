package Shapes;


import java.awt.*;
import org.json.simple.JSONObject;

        
public abstract class Polygons implements Shape, Moveable,Cloneable {
    private Point position, draggingPoint;
    private Color borderColor;
    private Color fillColor;
    private String objectName;
    private boolean isCorners;
    private final int CORNERSIZE = 20;

    public int getCORNERSIZE() {
        return CORNERSIZE;
    }

    public Polygons(Point position) {
        this.position = position;
    }

    public boolean isCorners() {
        return isCorners;
    }

    public void setIsCorners(boolean isCorners) {
        this.isCorners = isCorners;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    @Override
    public Color getBorderColor() {
        return this.borderColor;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public abstract void draw(Graphics canvas);

    @Override
    public void setDraggingPoint(Point point) {
        this.draggingPoint = point;
    }

    abstract public void drawCorners();

    abstract public void removeCorners();

    abstract public void resizeTo(Rectangle draggedCorner, Point draggedPoint);

    

        @Override
        public Point getDraggingPoint () {
            return this.draggingPoint;
        }

        public String extractColor (String Col){

            return Col.substring(15, Col.length() - 1);
        }
        public JSONObject toJSONobject ()
        {
            JSONObject jobj = new JSONObject();
            JSONObject mainObj = new JSONObject();
            JSONObject pointJson = new JSONObject();
            pointJson.put("X", position.x + "");
            pointJson.put("Y", position.y + "");
            jobj.put("position", pointJson);
            jobj.put("fillColor", extractColor(fillColor.toString()));

            if (this instanceof Oval oval) {

                jobj.put("Width", oval.getWidth());
                jobj.put("Height", oval.getHeight());
                jobj.put("objectName", oval.getObjectName());
                jobj.put("borderColor", extractColor(borderColor.toString()));
            } else if (this instanceof LineSegment line) {
                JSONObject pointJson2 = new JSONObject();
                pointJson2.put("X", line.getEndPosition().x + "");
                pointJson2.put("Y", line.getEndPosition().y + "");
                jobj.put("endPosition", pointJson2);
                jobj.put("objectName", line.getObjectName());

            } else if (this instanceof Rectangle rect) {
                jobj.put("height", rect.getHeight());
                jobj.put("width", rect.getWidth());
                jobj.put("objectName", rect.getObjectName());
                jobj.put("borderColor", extractColor(borderColor.toString()));
            } else if (this instanceof Triangle tri) {
                JSONObject pointJson2 = new JSONObject();
                pointJson2.put("X", tri.getPoint2().x + "");
                pointJson2.put("Y", tri.getPoint2().y + "");
                jobj.put("point2", pointJson2);
                JSONObject pointJson3 = new JSONObject();
                pointJson3.put("X", tri.getPoint3().x + "");
                pointJson3.put("Y", tri.getPoint3().y + "");
                jobj.put("point2", pointJson2);
                jobj.put("point3", pointJson3);
                jobj.put("objectName", tri.getObjectName());
                jobj.put("borderColor", extractColor(borderColor.toString()));
            }
            mainObj.put("Shape", jobj);
            return mainObj;


        }

        @Override
        public abstract boolean contains (Point point);

        @Override
        public abstract void moveTo (Point point);

        public static int[] RGBvaluess (String s)
        {
            String[] phase1 = s.split(",");
            int[] rgb = new int[3];
            String[] phase2;
            for (int i = 0; i < 3; i++) {
                phase2 = phase1[i].split("=");
                rgb[i] = Integer.parseInt(phase2[1]);
                // System.out.println(rgb[i]);
            }
            return rgb;
        }
        public static Color returnCol (String s)
        {

            int Colorrgb[] = Polygons.RGBvaluess(s);
            Color Color = new Color(Colorrgb[0], Colorrgb[1], Colorrgb[2]);
            return Color;
        }
        @Override
        public Object clone () throws CloneNotSupportedException {
            return super.clone();
        }


    }



