Fortgeschrittene Programmierung (Java 2)

# Übung 2

Diese Übung wird erstmals als Branch auf GitHub eingereicht. Dazu gibt es unten recht kleinteilige Anweisungen, in späteren Übungen wird das nicht mehr so genau beschrieben.

## a) Repository klonen und Eclipse-Projekt anlegen

Klonen Sie dieses Repository direkt in Eclipse, indem Sie `File > Import ...` wählen. Im Dialog danach wählen Sie den `Git`-Zweig und `Projects from Git`, gefolgt von `Clone URI`. Die URI bekommen Sie, indem Sie auf GitHub den grünen Knopf `Code` anklicken, und dann den mit https beschrifteten Link kopieren. Für diese Übung ist das `https://github.com/idh-cologne-java-2-summer-2023/exercise-02.git`.

Klicken Sie auf `Next >` und vergessen Sie im nächsten Dialog nicht, ihre GitHub-Authentifizierungsdaten anzugeben (damit Sie später auch wieder etwas hochladen können).

Wählen Sie unter `Branch Selection` den Branch `main` aus, und danach das Verzeichnis auf ihrer lokalen Festplatte.

Letzter Schritt: Das git-repository enthält auch ein Eclipse-Projekt, das sie importieren möchten. Wählen Sie dazu `Import existing Eclipse projects`.

Danach sollte das Projekt als normales Eclipse-Projekt sichtbar sein. Im Kontextmenü sollte jetzt auch das `Team`-Untermenü sichtbar sein.

## b) Branch
Legen Sie einen neuen Branch an, den Sie so nennen wie Ihr GitHub-Benutzername ist (damit er eindeutig ist). Alle weiteren Änderungen machen Sie in Ihrem eigenen Branch.

In Eclipse wählen Sie dazu mit `Team`-Kontextmenü die Option `Switch To` und dann `New Branch`.

## c) ATM aktualisieren

Als Basiscode innerhalb des Projektes finden Sie die Referenzlösung aus Übung 1. Wenn Sie lieber Ihre eigene Lösung für die Aufgabe verwenden möchten, kopieren Sie sie herein, und machen direkt einen Git-Commit, um diese erste Änderung festzuhalten.

Danach erweitern Sie die ATM-Klasse um zwei Aspekte:

1. Der Automat sollte verschiedene Konten verwalten können. D.h. dass Benutzer:innen im Dialog zunächst ihre Kontonummer angeben müssen, und danach den Betrag. Der Geldautomat weiß dann für alle inviduellen Benutzer:innen, wie viel Geld diese noch auf dem Konto haben.

2. Der Automat verwaltet außerdem, wie viel Bargeld er noch zur Verfügung hat. D.h. auch wenn eine Benutzerin genug Geld auf dem Konto hat, kann es sein, dass sie das Geld nicht bekommt, weil der Automat leer ist. Wenn eine Auszahlung passiert ist, sollte der Automat seinen Bargeldbestand jeweils aktualisieren.

Folgende Interaktionen sollten also passieren können:

```
Enter your account number: 123
Enter the amount to withdraw: 21
Ok, here you go!
Enter your account number: 234
Enter the amount to withdraw: 452
Sorry, you don't have enough money in the bank.
Enter your account number: 345
Enter the amount to withdraw: 56
Sorry, the ATM doesn't have that much cash anymore.
```

## d) Commit und Push
Committen Sie alle Ihre Änderungen am Quellcode, und pushen Sie den neuen Branch auf das remote namens `origin` (= GitHub). Um über HTTPS pushen zu können, müssen Sie auf GitHub ein sog. *personal access token* erzeugen, und dieses anstelle Ihres Passwortes verwenden. [Hier](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token) gibt es dazu eine Anleitung. Bei scopes müssen Sie nur einen Haken bei `repo` machen, alles andere kann so bleiben.

In Eclipse wählen Sie dazu `Team > Push to origin ...` oder `Team > Push branch USERNAME ...`

