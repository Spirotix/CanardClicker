
# CanardClicker

CanardClicker est un jeu de type clicker où les joueurs interagissent avec un canard pour progresser et débloquer des améliorations. Ce projet est structuré en plusieurs dossiers et fichiers pour faciliter son développement et sa maintenance.

---

## Table des matières

1. [Structure du projet](#structure-du-projet)
2. [Prérequis](#prérequis)
3. [Installation](#installation)
4. [Utilisation](#utilisation)
5. [Détails des composants](#détails-des-composants)
6. [Contributions](#contributions)
7. [License](#license)

---

## Structure du projet

```
CanardClicker/
├── compile/
├── code/
│   ├── ihm/
│   │   ├── FrameCanardClicker.java
│   │   ├── PanelAmelioration.java
│   │   ├── PanelCanardGeant.java
│   ├── metier/
│   │   ├── GestionBruitage.java
│   │   ├── GenerationCanard.java
│   ├── ControleurCanardClicker.java
├── fichier/
│   ├── Bruitage/
│   │   ├── pet.mp3
│   ├── Image/
│       ├── Canard.png
```

---

## Prérequis

- **Java JDK 8+** pour compiler et exécuter le projet.
- Un IDE Java ou un éditeur de texte (comme IntelliJ IDEA, Eclipse ou Visual Studio Code avec un plugin Java).
- Un lecteur audio compatible pour les fichiers `.mp3`.

---

## Installation

1. Clonez ce dépôt sur votre machine locale :
   ```bash
   git clone https://github.com/votre-utilisateur/canardclicker.git
   ```

2. Assurez-vous que le JDK est correctement configuré dans votre environnement.

3. Importez le projet dans votre IDE ou compilez-le directement depuis le terminal.

---

## Utilisation

1. Lancez le fichier principal **`ControleurCanardClicker`** depuis l'IDE ou via la commande suivante :
   ```bash
   java -cp ./code ControleurCanardClicker
   ```

2. Interagissez avec l'interface graphique pour cliquer sur le canard, gagner des points et débloquer des améliorations.

---

## Détails des composants

### Dossier `ihm` (Interface Homme-Machine)
- **`FrameCanardClicker.java`** : La fenêtre principale du jeu.
- **`PanelAmelioration.java`** : Permet de gérer et afficher les options d'amélioration.
- **`PanelCanardGeant.java`** : Contient le canard principal à cliquer.

### Dossier `metier` (Logique Métier)
- **`GestionBruitage.java`** : Gère les sons du jeu, comme le bruitage des clics.
- **`GenerationCanard.java`** : Génère les canards et gère leur logique.

### Dossier `fichier` (Ressources)
- **`Bruitage/pet.mp3`** : Le fichier audio joué lors d'une action spécifique.
- **`Image/Canard.png`** : L'image principale utilisée pour représenter le canard.

---

## Contributions

Les contributions sont les bienvenues ! Pour contribuer :
1. Forkez le dépôt.
2. Créez une branche pour vos modifications :
   ```bash
   git checkout -b ma-branche
   ```
3. Soumettez une *pull request* lorsque vos changements sont prêts.

---

## License

Ce projet est sous licence **MIT**. Vous êtes libre de l'utiliser, le modifier et le redistribuer avec attribution. Consultez le fichier `LICENSE` pour plus d'informations.

---

**Amusez-vous bien avec CanardClicker ! 🦆**
