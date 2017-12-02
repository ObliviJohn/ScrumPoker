#!bin/sh
for file in *.png
do
	mv "$file" "${file%.jpg.png}.png"
done
