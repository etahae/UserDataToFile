SRC = src/Main.java src/User.java
OUT = src/Main.class src/User.class
FILE = ./Users

all : $(SRC)
	@ javac src/Main.java src/User.java

clean :
	@ rm -rf $(OUT)

fclean: clean
	@ rm -rf $(FILE)

run : $(OUT)
	@ java src/Main