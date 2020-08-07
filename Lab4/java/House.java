public class House extends java.lang.Object{

    public House.Cuboid[] rooms;
    public House.Pyramid houseTop;
    private char houseType;
    private int countRooms;
    private int houseNumber;
    private int baseLength;
    private int baseWidth;
    private int height;
    private int pyramidHeight;

    public House(int maxNoOfRooms,
                int houseNumber,
                int baseLength,
                int baseWidth,
                int height,
                int pyramidHeight,
                char houseType){

        this.rooms = new House.Cuboid[maxNoOfRooms];
        this.houseTop = new House.Pyramid();
        this.houseNumber = houseNumber;
        this.baseLength = baseLength;
        this.baseWidth = baseWidth;
        this.height = height;
        this.pyramidHeight = pyramidHeight;
        this.houseType = houseType;
        this.countRooms = 0;
    }

    public class Cuboid extends java.lang.Object{

        private int roomLength;
        private int cost;
        private int roomWidth;
        private int roomHeight;
        public House.Cuboid.Rectangle[] walls;

        public Cuboid​(int length, int width, int cost){
            this.walls = new House.Cuboid.Rectangle[6];
            this.roomHeight = height;
            this.roomLength = length;
            this.roomWidth = width;
            this.cost = cost;
            countRooms++;
        }

        public Cuboid(int length, int width){
            this.walls = new House.Cuboid.Rectangle[6];
            this.roomHeight = height;
            this.roomLength = length;
            this.roomWidth = width;
            this.cost = 0;
            countRooms++;
        }

        public class Rectangle extends java.lang.Object{
            private char wallType;
            private int wallLength;
            private int wallWidth;
            private char wallState;

            public Rectangle​(char wallType, boolean isRaining){
                this.wallType = wallType;
                if(isRaining)
                    this.wallState = 'b';
                else
                    this.wallState = 'g';

                if(wallType == 'w')
                    this.wallLength = roomWidth;
                else if(wallType == 'l')
                    this.wallLength = roomLength;
                else
                    this.wallLength = roomLength;

                if(wallType == 'f' || wallType == 'c')
                    this.wallWidth = roomWidth;
                else
                    this.wallWidth = roomHeight;
            }

            public int getArea(){
                return this.wallWidth*this.wallLength;
            }

            public char getWallCondition(){
                return this.wallState;
            }
        }

        public int getCost(){
            return this.cost;
        }

        public int getVolume(){
            return this.roomHeight*this.roomWidth*this.roomHeight;
        }
    }

    public class Pyramid extends java.lang.Object{
        private int pyramidHeight;
        private int pyramidBaseLength;
        private int pyramidBaseWidth;
        public House.Pyramid.Triangle[] roofWalls;

        public Pyramid(){
            this.pyramidHeight = pyramidHeight;
            this.pyramidBaseWidth = baseWidth;
            this.pyramidBaseLength = baseLength;
            roofWalls = new House.Pyramid.Triangle[4];
        }

        public class Triangle extends java.lang.Object{
            private char triangleType;
            private int baseSide;
            private int wallSide1;
            private int wallSide2;

            public Triangle​(char triangleType,int side1,int side2){
                this.triangleType = triangleType;
                this.wallSide1 = side1;
                this.wallSide2 = side2;
                if(triangleType == 'w')
                    this.baseSide = pyramidBaseWidth;
                else
                    this.baseSide = pyramidBaseLength;
            }

            public int getTriangleArea(){
                int s = ((this.baseSide + this.wallSide2 + this.wallSide1)/2);
                return (s*(s-this.baseSide)*(s-this.wallSide1)*(s-this.wallSide2));
            }
        }

        public int getVolume(){
            return (this.pyramidBaseWidth*this.pyramidBaseLength*this.pyramidHeight)/3;
        }

        public int getSurfaceArea(){
            int area = 0;
            for(int i=0;i<4;i++)
                area += roofWalls[i].getTriangleArea();
            return area;
        }
    }

    public int getHouseNumber(){
        return this.houseNumber;
    }

    public int getCountRooms(){
        return this.countRooms;
    }

    public int getBadWalls(){
        int count=0;
        for(int i=0;i<this.countRooms;i++)
        {
            for(int j=0;j<6;j++)
            {
                if(rooms[i].walls[j].wallState == 'b')
                    count++;
            }
        }
        return count;
    }

    public int houseVolume(){
        int basevolume = this.baseLength*this.baseWidth*this.height;
        return (basevolume + houseTop.getVolume());
    }

    public int freeSpace(){
        int basevolume = this.baseLength*this.baseWidth*this.height;
        int roomvol = 0;
        for(int i=0;i<this.countRooms;i++)
            roomvol += rooms[i].getVolume();

        return (basevolume - roomvol);
    }

    public int getRent(){
        int rent = 0;
        if(this.houseType == 'c')
        {
            for(int i=0; i<this.countRooms;i++)
                rent+=rooms[i].getCost();
        }
        else
            rent = this.getSurfaceArea();

        return rent;
    }

    public char getHouseType(){
        return this.houseType;
    }

    public int getSurfaceArea(){
        return ((2*this.height*(this.baseLength+this.baseWidth)) + (houseTop.getSurfaceArea()));
    }
}
