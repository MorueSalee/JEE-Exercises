package fr.eni.ecole.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Page;

public class BookManagerImpl implements BookManager {

	private List<Page> pageList = new ArrayList<>();

	public BookManagerImpl() {

		Page page1 = new Page(1,
				"Vous êtes un jeune garçon, en soif d'aventures.\r\n"
						+ "Vous vous reveillez dans votre maison au Bourg Galette.\r\n"
						+ "Rapidement, on vient toquer à votre porte.\r\n"
						+ "C'est votre amie Maria qui vient vous parler d'une épée de légende \r\n"
						+ "permettant de sauver la princesse Random, comme dans 25 jeux de la célèbre \r\n"
						+ "licence Zeldo.\r\n" + "<br>" + "Que faites-vous ?\r\n" + "<br><br>"
						+ "3 - Suivre votre instinct et partir en quête de pouvoir<br>"
						+ "6 - Prendre le petit-déjeuner devant la télé avant de partir");

		Page page2 = new Page(2,
				"Regardez vous, n'ayant pas voulu suivre le chemin de l'aventure\r\n"
						+ "vous êtes resté dans votre village natal pour élever des hamsters\r\n"
						+ "éléctriques et des tortues oignons. Votre histoire s'achève ici \r\n"
						+ "professeur Chiant.\r\n" + "<br><br>" + "1 - Revenir au début de l'histoire\r\n" + "",
				true);

		Page page3 = new Page(3,
				"L'aventure vous appelle, votre sac à dos enfilé vous partez, \r\n"
						+ "du haut de vos 12 ans, en quête de la Maitre-épée. Peu de temps \r\n"
						+ "après votre départ, vous tombez nez à nez avec un ogre vert mystérieux.\r\n"
						+ "L'ogre se présente à vous sous le nom de \"Shrouk\". Ce dernier \r\n"
						+ "peut vous aidez en échange d'un rubis rouge.\r\n" + "<br><br>" + "2 - Rebrousser chemin<br>"
						+ "4 - Payer Shrouk pour avancer<br>" + "5 - Affronter shrouk dans un octogone");

		Page page4 = new Page(4,
				"Vous fouillez dans vos poches à la recherche de vos rubis, mais vous vous \r\n"
						+ "rendez compte que vous avez oublié votre bourse à la maison. Alors que vous esquissez\r\n"
						+ "un sourire géné en expliquant que vous n'avez pas un rond, l'ogre Shrouk balance\r\n"
						+ "sa massue cloutée dans votre direction. Le contact de cette arme de 150kg avec\r\n"
						+ "votre tête avec  produit un son rappelant étrangement le nom de son propriétaire :\r\n"
						+ "*SHROUUUK*\r\n" + "<br><br>" + "1 - Revenir au début de l'histoire");

		Page page5 = new Page(5, "L'ogre à l'odeur nauséabonde vous conduit derrière un bosquet, où vous découvrez\r\n"
				+ "un ring de MMA, dans lequel se trouve un petit personnage en costume. \r\n"
				+ "Celui-ci vous interpèle à travers son micro :\r\n"
				+ "- \"EEEET voiciiii notre nouveau chaaaaaaaalenger !!! Venu tout droit du Bourg Galette,\r\n"
				+ "du haut de ses 1 mèèèèètres 50 et 47kg, j'ai nommé, le Hééééééééérooos !!!\"\r\n" + "<br>"
				+ "Vous montez péniblement sur le ring. L'arbitre vous glisse un clin d'oeil, mais\r\n"
				+ "cela vous angoisse plus que cela ne vous rassure. L'arbitre continue :\r\n"
				+ "- \"Il est vert ! Il est grand ! Il est gros ! Il ne sent pas bon, mais cumule 387\r\n"
				+ "victoires à son actif ! J'ai ! Nommé ! Le Monstre ! Le Brutal ! L'invaincu !\r\n"
				+ "Mooooonsieuuur SSSSCCCHHROUUUUK !!!\r\n" + "<br>"
				+ "Des tonerres d'applaudissement retentissent dans la forêt, bien qu'il n'y ait pas \r\n"
				+ "de public. Schrouk vous dévisage et vous fait signe d'attaquer en premier.\r\n" + "<br>"
				+ "Que faites vous ?\r\n" + "<br><br>" + "- 7 Tenter un coup de pied rotatif dans la machoire<br>"
				+ "8 - Lancer un Ushi Mata pour le projeter au sol<br>"
				+ "9 - Le provoquer en évoquant des rapports intimes entre sa mère vous<br>"
				+ "10 - Appeler votre amie Maria à la rescousse<br>" + "");

		Page page6 = new Page(6,
				"Après que vous vous soyez servi un bon bol de diabésquick (avec le lait versé avant),\r\n"
						+ "vous remarquez votre bourse qui trainait au milieu de la table du salon. Un peu plus\r\n"
						+ "et vous alliez l'oublier ! Ca aurait été dommage de faire la manche pour manger le \r\n"
						+ "midi !\r\n" + "<br>" + "*Vous récupérez bourse contenant un rubis rouge*\r\n" + "<br>"
						+ "Que faites-vous ?\r\n" + "<br><br>"
						+ "2 - Rien, rester chez vous sous la couette comme un couard<br>"
						+ "3 - Suivre votre instinct et partir en quête de pouvoir ",
				"Rubis Rouge");

		Page page7 = new Page(7,
				"Malheuresement, vous êtes trop petit pour pouvoir atteindre la machoire collossale\r\n"
						+ "de l'ogre et vous tombez sur le ring en essayant de lui porter un coup. Alors que \r\n"
						+ "vous vous relevez, Schrouk vous attrappe par les pieds et commence à vous secouez \r\n"
						+ "dans tous les sens, c'est bien sur pour imiter son idole Houlk des Vengeurs face Lokiki.\r\n"
						+ "Votre corps, ne pouvant supporter les assauts du géant, se disloque.\r\n" + "<br><br>"
						+ "1 - Revenir au début de l'histoire");

		Page page8 = new Page(8,
				"Votre technique secrete s'avère dévastatrice. Vos petons viennent brosser l'entrejambes \r\n"
						+ "de votre adversaire, le terrassant sur le coup. Le géant se tord de douleur tout en vous\r\n"
						+ "suppliant de ne plus jamais utiliser ce coup. L'arbitre vous proclame roi de la forêt\r\n"
						+ "et par conséquent Shrouk fraichement eunuque s'agenouille devant vous. L'ogre vous propose\r\n"
						+ "de vous accompagner pour la suite.\r\n" + "<br><br>" + "- 11 Accepter son aide<br>"
						+ "12 - Repartir en solitaire victorieux \r\n" + "");

		Page page9 = new Page(9,
				"Vous tentez de provoquer l'ogre mais en évoquant simplement sa génitrice, ce dernier \r\n"
						+ "devient fou de rage. Vous êtes projeté par dessus la troisième corde ce qui vous \r\n"
						+ "déchire la colonne vertebrale mettant ainsi fin à votre aventure.\r\n" + "<br><br>"
						+ "1 - Revenir au début de l'histoire");

		Page page10 = new Page(10,
				"Vous appelez votre ami Maria a la rescousse. Malheuresement, ce n'est pas très efficace.\r\n"
						+ "L'adversaire étant un ogre et non un gorille, ce dernier vous utilise comme des maracas.\r\n"
						+ "Vous tombez dans un long coma.\r\n" + "<br><br>" + "1 - Revenir au début de l'histoire");

		Page page11 = new Page(11,
				"Vous attrapez la main de shrouk pour le relever et acceptez volontier son aide.\r\n"
						+ "Vous repartez tous deux main dans la main en quête de la maitre épée.\r\n" + "<br>"
						+ "La suite au prochain tome...\r\n" + "<br><br>" + "1 - Revenir au début de l'histoire");

		Page page12 = new Page(12, "Vous rejetez l'aide de la créature, en vous retournant.\r\n"
				+ "Vous repartez seul pour poursuivre votre quête légendaire.\r\n" + "<br>"
				+ "La suite au prochain tome...\r\n" + "<br><br>" + "1 - Revenir au début de l'histoire\r\n" + "");

		Page page13 = new Page(13,
				"Shrouk accepte votre offre avec grand plaisir et repars avec vous en tant que guide.\r\n"
						+ "Vous continuez votre route tous deux main dans la main en quête de la maitre épée.\r\n"
						+ "<br>" + "La suite au prochain tome...\r\n" + "<br><br>"
						+ "1 - Revenir au début de l'histoire");

		// Page 1
		page1.getPageList().add(page3);
		page1.getPageList().add(page6);

		// Page 2
		page2.getPageList().add(page1);

		// Page 3
		page3.getPageList().add(page2);
		page3.getPageList().add(page5);

		// Page 4
		page4.getPageList().add(page1);

		// Page 5
		page5.getPageList().add(page8);
		page5.getPageList().add(page7);
		page5.getPageList().add(page9);
		page5.getPageList().add(page10);

		// Page 6
		page6.getPageList().add(page2);
		page6.getPageList().add(page3);

		// Page 7
		page7.getPageList().add(page1);

		// Page 8
		page8.getPageList().add(page11);
		page8.getPageList().add(page12);

		// Page 9
		page9.getPageList().add(page1);

		// Page 10
		page10.getPageList().add(page1);

		// Page 11
		page11.getPageList().add(page1);

		// Page12
		page12.getPageList().add(page1);

		// Page13
		page13.getPageList().add(page1);

		pageList.add(page1);
		pageList.add(page2);
		pageList.add(page3);
		pageList.add(page4);
		pageList.add(page5);
		pageList.add(page6);
		pageList.add(page7);
		pageList.add(page8);
		pageList.add(page9);
		pageList.add(page10);
		pageList.add(page11);
		pageList.add(page12);
		pageList.add(page13);
	}

	@Override
	public Page getPage(Integer numero) {
		return pageList.get(numero);
	}

}
