# TP DEVMO Edwin & Bryan
tp-devmo-edwin-bryan-2h-who created by GitHub Classroom

## Présentation du projet
Nous avions pour projet, une application regroupant tous les services de l'école (Onboard, Webmail, Hippocampus, ...), et cela, sans devoir se connecter à chaque fois.
Nous voulions nous concentrer sur l'affichage du planning qui est une des fonctions principales de l'application. 
En effet, les étudiants consultent quotidiennement leur planning, nous voulions donc pouvoir y accéder rapidement.

## Description de l'application
Nous commençons par nous connecter avec nos identifiants de Centrale. (Nous n'avons pas implémenter la connexion, nous utilisons admin/admin).
Après la connexion, les identifiants sont enregistrés dans le téléphone pour pouvoir se connecter directement lors des prochaines ouvertures de l'application.  
Nous arrivons sur le planning, pour avoir une consultation rapide. 
Nous avons implémenté 2 cours dans le planning qui seront affichés à la date du jour d'ouverture de l'application à chaque fois, pour visualiser ce que cela pourrait donner. Nous n'avons pas implementé une base de données mais ce n'est pas si difficile de le faire puisque nous avons des listes de la classe Event qui representent les cours du Planning et dont les attributs peuvent être modifiés avec les données que nous pouvons trouver dans une telle base de données.  
Ensuite nous avons choisi d'avoir accès à la carte du campus car c'est une fonctionnalité qui n'a pas besoin de connexion.
Mais en réalité, avoir accès à sa boîte mail est plus intéressant.  
Nous avons un menu qui nous permet d'accéder aux autres services (SVP, Intranet, ...). 
Pour notre version, nous avons ajouté des liens vers les services, pour pouvoir y accéder.

## Implementation du Planning
Pour l'élaboration du planning, nous nous sommes basés sur le projet suivant: Lien GitHub: https://github.com/codeWithCal/CalendarTutorialAndroidStudio.git. Nous avons adapté le code à notre application car nous travaillons avec des fragments alors que ce projet est basé sur des activités.
