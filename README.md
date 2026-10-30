# TP3 – Serveur Multi-threads : Sockets en mode connecté TCP

Ce projet est réalisé dans le cadre du TP3 de la matière **Développement d’applications réparties**, durant l’année universitaire 2026–2027, à la Faculté des Sciences de Sfax[cite: 13].

---
## 📌 Activité 3-1 : Acceptation de plusieurs clients (Serveur Multi-thread)

### 1. Présentation et Objectifs
Les applications Client/Serveur développées dans les TP précédents ne permettaient de gérer qu'un seul client à chaque exécution du serveur. L'objectif de cette activité est de concevoir un **serveur multi-thread** capable de traiter plusieurs clients simultanément en utilisant les sockets TCP[cite: 14].

Les objectifs principaux sont :
* Comprendre et appliquer le principe d'un serveur multithread basé sur les sockets TCP en Java[cite: 13].
* Gérer l'affichage des informations de chaque client connecté (adresse IP via `getRemoteSocketAddress()` et numéro d'ordre)[cite: 14].
* Envoyer à chaque client son numéro d'ordre de communication[cite: 14].

### 2. Architecture et Principe de fonctionnement
* **Le Serveur Principal (`ServerMultiThread`) :** Écoute en permanence sur le port `1234` via une boucle infinie (`while(true)`). Dès qu'un client se connecte (`accept()`), il incrémente un compteur et lance un thread indépendant[cite: 14].
* **Le Gestionnaire de Client (`ClientHandler`) :** Implémente l'interface `Runnable` pour dialoguer avec chaque client en parallèle, récupérer son adresse IP et lui attribuer son numéro d'ordre de connexion[cite: 14].
* **Le Client (`Client3_1`) :** Se connecte au serveur, lit son message d'accueil personnalisé (numéro d'ordre) et échange des données[cite: 14].

### 3. Captures d'écran et Résultats

* **3.1. Démarrage du serveur :**
  Mise en écoute du serveur multi-thread sur le port 1234.
  ![Serveur en attente](Captures/01_tp3_activite31_serveur_ecoute.png)

* **3.2. Exécution du Client n°1 :**
  Connexion réussie du premier client et réception de son numéro d'ordre.
  ![Client 1](Captures/02_tp3_activite31_client_execution.png)

* **3.3. Détection du Client n°1 côté serveur :**
  Affichage des informations du client connecté (adresse IP et numéro d'ordre).
  ![Serveur - Client 1](Captures/03_tp3_activite31_serveur_clients.png)

* **3.4. Exécution du Client n°2 :**
  Connexion simultanée du deuxième client gérée en parallèle par le serveur.
  ![Client 2](Captures/04_tp3_activite31_client2_execution.png)

* **3.5. Gestion simultanée des clients côté serveur :**
  Affichage consolidé montrant le traitement multi-threads des deux clients connectés.
  ![Serveur - Multi-clients](Captures/05_tp3_activite31_serveur_clients.png)

---

## 🚀 Conclusion
Cette activité m'a permis d'approfondir la programmation multi-threads en Java appliquée aux sockets réseau. Elle m'a permis de dépasser la limitation séquentielle des serveurs classiques pour concevoir une application robuste capable de dialoguer de manière synchrone et indépendante avec plusieurs clients connectés simultanément[cite: 14].