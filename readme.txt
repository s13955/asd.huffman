Przykładowe użycie:
$ java -Dfile.encoding=UTF-8 -jar Huffman.jar input.txt output.txt

Plik input.txt zawiera następujący ciąg znaków:
sterroryzowany zorro kręci horror.

Wyjście programu:
{ =000, a=01000, c=00101, e=01001, h=00111, i=11011, k=01111, .=00110, n=01100, 
o=111, r=10, s=01110, t=11010, w=00100, ę=01101, y=1100, z=0101}
Before compression: 34 bytes
After compression: 16 bytes
Ratio: 213%


Plik output.txt zawiera następującą zawartość (HEX):
76 93 5E C5 E4 43 30 2F AE 1F 34 BB 07 F5 E3 00

HEX = BIN
 76 = 0111 0110
 93 = 1001 0011
 5E = ‭0101 1110‬
 C5 = ‭1100 0101‬
 E4 = ‭1110 0100‬
 43 = ‭0100 0011‬
 30 = ‭0011 0000‬
 2F = ‭0010 1111‬
 AE = ‭1010 1110‬
 1F = ‭0001 1111‬
 34 = ‭0011 0100‬
 BB = ‭1011 1011‬
 07 = 0000 0111
 F5 = ‭1111 0101‬
 E3 = ‭1110 0011‬
 00 = 0000 0000

Ręczna dekompresja:
01110  11010  01001  10  10  111  10  ‬1100  0101‬  111  00100  ‬01000  011‬00
s      t      e      r   r   o    r   y     z     o    w      a      n

1100  00‬0  0101  111  ‬10  10  111  0‬00  01111  1‬0  01101  00‬101  11011 ‬ 000
y     ' '  z     o    r   r   o    ' '  k      r   ę      c      i      ' '

00111  111  10  10  1‬11  10  0011‬0  0000000
h      o    r   r   o    r   .

Bug 1:
Liczba bitów (1 bajt = 8 bitów) zapisana w pliku jest większa od liczby bitów 
po wykonaniu kompresji (uzupełniona zerami).

Liczba bitów po kompresji = 121:
01110  11010  01001  10  10  111  10  1100  0101  111  00100  01000  01100
1100  000  0101  111  10  10  111  000  01111  10  01101  00101  11011  000
00111  111  10  10  111  10  00110

Liczba bitów w zapisanym pliku = 128:
01110  11010  01001  10  10  111  10  ‬1100  0101‬  111  00100  ‬01000  011‬00
1100  00‬0  0101  111  ‬10  10  111  0‬00  01111  1‬0  01101  00‬101  11011 ‬ 000
00111  111  10  10  1‬11  10  0011‬0 0000000
