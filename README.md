# gra_typu_duckshooter
Program bedacy gra w stylu ”duck shooter” połaczonej z TowerDefense. Podczas rozgrywki od lewej do prawej oraz od prawej do lewej poruszaja sie kaczki róznych kolorów. Gra polega na ”zestrzeliwaniu” kaczek i zapobiegnieciu przedostania sie ich na druga strone okna. Gracz ma na celu klikac w kaczke tyle razy, ile potrzeba, aby go ”zestrzelic”.

========================

Program bedacy gra w stylu ”duck shooter” połaczonej z TowerDefense. Podczas
rozgrywki od lewej do prawej oraz od prawej do lewej poruszaja sie kaczki róznych kolorów. Gra
polega na ”zestrzeliwaniu” kaczek i zapobiegnieciu przedostania sie ich na druga strone okna.
Gracz ma na celu klikac w kaczke tyle razy, ile potrzeba, aby go ”zestrzelic”.

Przykładowo – zółte obiekty beda potrzebowały 1 klikniecia, czerwone – 5 klikniec, purpurowe
10, a rózowe 20. Sa to przykładowe wartosci i kolory, które moga Panstwo dowolnie
modyfikowac.

Celem gracza jest utrzymanie jak najdłuzej czystego pola bez kaczek.
Gra konczy sie w sytuacji, gdy na druga strone okna przedostanie sie wiecej iz 10 kaczek (Mozna potraktowac
to tak, jakby gracz miał 10 zyc, a kazde przepuszczenie kaczki na druga strone odbierało 1 zycie).

Nalezy zaimplementowac równiez przeszkody (np. chmury), które beda zakrywały kurczaki
i chroniły je przed kliknieciami.

Nalezy zapewnic w pełni funkcjonalny interfejs graficzny. Konsola polecen (CLI ) moze byc jedynie
pomoca informacyjna, ale nie moze zachodzic tam zadna znaczaca interakcja uzytkownika
z programem.

Program po uruchomieniu powinien wyswietlac menu główne składajace sie z opcji:

• New Game - nowa gra

• High Scores - tabela wyników

• Exit – wyjscie

Po uruchomieniu nowej gry, gracz zostanie zapytany w osobnym oknie jaki stopien trudnosci
chce rozegrac (implementacja stopni trudnosci dowolna). 
Po uruchomieniu gry w nowym oknie
wyswietlana jest plansza gry, a licznik czasu rusza (warto zauwazyc, ze licznik czasu powinien
byc realizowany w osobnym watku, zeby nie blokowac interakcji z oknem).
Podczas gry musi byc widoczny licznik punktów oraz czasu, aktualizowane na zywo podczas rozgrywki.
Gra toczy sie według wyzej wymienionych zasad do momentu utraty wszystkich zyc. Nalezy zapewnic
mozliwosc przerwania gry w dowolnym momencie poprzez wybrany przez Panstwa złozony skrót
klawiszowy (np. Ctrl+Shift+Q), który spowoduje powrót do menu głównego.

Po zakonczeniu gry, w nowym oknie gracz proszony jest o swoja nazwe pod jaka ma byc
zapisywany w rankingu.

Ranking liczony jest na podstawie czasu i stopnia trudnosci (np. liczba zestrzelonych kurczaków*
stopien trudnosci/czas). Nalezy zapewnic trwałosc rankingu po ponownym uruchomieniu
aplikacji, czyli nalezy go przechowywac w pliku na dysku.
Postac przechowywanych danych
jest sprawa drugorzedna i nie musi byc czytelna dla gracza (mozna wykorzystac np. interfejs
Serializable).

Po wybraniu opcji rankingu z menu głównego, zostaje on wyswietlony uzytkownikowi. Poniewaz
okno rankingu moze byc relatywnie duze, dlatego nalezy zadbac o odpowiednie wyswietlanie
rankingu (paski przewijania), w razie gdyby nie miescił sie on w oknie racjonalnych rozmiarów.
