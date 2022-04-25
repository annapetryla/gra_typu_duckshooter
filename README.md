# gra_typu_duckshooter
Program bedacy gra w stylu ”duck shooter” połaczonej z TowerDefense. Podczas rozgrywki od lewej do prawej oraz od prawej do lewej poruszaja sie kaczki róznych kolorów. Gra polega na ”zestrzeliwaniu” kaczek i zapobiegnieciu przedostania sie ich na druga strone okna. Gracz ma na celu klikac w kaczke tyle razy, ile potrzeba, aby go ”zestrzelic”.

Celem gracza jest utrzymanie jak najdłuzej czystego pola bez kaczek.
Gra konczy sie w sytuacji, gdy na druga strone okna przedostanie sie wiecej iz 10 kaczek (
tak, jakby gracz miał 10 zyc, a kazde przepuszczenie kaczki na druga strone odbierało 1 zycie).

Zaimplementowane są równiez przeszkody (np. chmury), które bedą zakrywały kurczaki
i chroniły je przed kliknieciami.


Program po uruchomieniu wyświetla menu główne składajace sie z opcji:

• New Game - nowa gra

• High Scores - tabela wyników

• Exit – wyjscie

Po uruchomieniu nowej gry, gracz zostanie zapytany w osobnym oknie jaki stopien trudnosci
chce rozegrac (implementacja stopni trudnosci za pomocą suwaka). 
Po uruchomieniu gry w nowym oknie
wyswietlana jest plansza gry, a licznik czasu rusza (licznik czasu realizowany w osobnym watku, zeby nie blokowac interakcji z oknem).
Podczas gry widoczny licznik punktów oraz czasu, aktualizowane na zywo podczas rozgrywki.
Gra toczy sie według wyzej wymienionych zasad do momentu utraty wszystkich zyc. Zapewniona
mozliwosc przerwania gry w dowolnym momencie poprzez wybrany przez złozony skrót
klawiszowy (np. Ctrl+Shift+Q), który powoduje powrót do menu głównego.

Po zakonczeniu gry, w nowym oknie gracz proszony jest o swoja nazwe pod jaka ma byc
zapisywany w rankingu.

Ranking liczony jest na podstawie czasu i stopnia trudnosci. Zapewniona trwałosc rankingu po ponownym uruchomieniu
aplikacji, czyli przechowywany w pliku na dysku (wykorzystanie interfejsu Serializable).

Po wybraniu opcji rankingu z menu głównego, zostaje on wyswietlony uzytkownikowi. Poniewaz
okno rankingu moze byc relatywnie duze, dlatego zostaje odpowiednio wyswietlony pzry użyciu
paskow przewijania, w razie gdyby nie miescił sie on w oknie racjonalnych rozmiarów.
