package coursemanager.persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class TextReader {

	/**
	 *  fichier texte sousjacent
	 */
	private BufferedReader aFile;

	/**
	 * Cree un lecteur pour un fichier dont le nom est donnee dans le parametre 'fileName'.
	 */
	public TextReader(String fileName) {
		
		try
		{
			aFile = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*/These couple of lines are used for reading the files within the jar, given that the files are at the same level of this class
		InputStream is = getClass().getResourceAsStream(fileName);
		aFile = new BufferedReader(new InputStreamReader(is));
		//*/
	}

	/**
	 * Cette methode transforme les donnees structurees provenant du fichier en une
	 * structure plus facile a manipuler: une liste de listes de strings, contenant
	 * des informations sur les donnees. 
     *
     * Le fichier texte contient les donnees pour chaque media, encode dans un
     * format facile a dechiffrer. Les informations de chaque item sont separes
     * par une ou plusieurs lignes vides. Les informations se composent de plusieurs
     * champs; chaque champ est contenu sur une ligne et est identifie par un prefixe
     * qui en decrit la nature. Voici un exemple de une base des donn�es de stock:
     * <pre>
     * %Id 1
     * %Name Hoegaarden
     * %Category BottledBeer
     * %Quantity 50
     * %Price 1.2
     * %Capacity 300
     * %Image_path images/bottled_beer/hoegaarden.jpg
     * %ExpDate 12/10/2010
     * </pre>
     * Un champ prefixe par %Category designe le type de produit, le champ prefixe
     * par %Name designe le nom du produit, le champ prefixe par %Id est un
     * identifiant unique du fichier, etc.
     * 
	 * La methode cree une liste contenant d'autres listes.
	 * Appellons ces dernieres listes des 'blocks'.
	 *  <pre>
	 *                  +-+-+               +-+-+    +-+-+
	 *           data = |.|.+---   ...  --->|.|.+--->|.|.|
	 *                  +++-+               +++-+    +++-+
	 *                   |                   |        |
	 *                   V                   V        V
	 *       _____________________________       _____________________________
	 *      |           Block 1           |     |     Block N                 |
	 *      |_____________________________|     |_____________________________| 
	 *
	 *       Un block contient des informations sur un item.
	 *       
	 *                 +-+-+              +-+-+            +-+-+
	 *       block i = |.|.+------------->|.|.+----------->|.|.+-----> ...
	 *                 +++-+              +++-+            +++-+
	 *                  |                  |       
	 *                  V                  V       
	 *             +--------+-----+    +----+-----------+  +------+--------+
	 *             |ID		|1	  +    |Name|Hoegaarden +  |Price | 10.5   |
	 *             +--------+-----+    +----+-----------+  +------+--------+
	 * </pre>
	 *       Un block est une liste qui contient des tableaux de String. Appellons ces tableaux des elements.
	 *       Chaque element est un tableau a deux entrees.<br/>
	 *       La premiere entree element[0] est le nom d'un champ, comme "Id", "Name", etc. <br/>
	 *       La deuxieme entree element[1] est la valeur de ce champ pour l'item encode dans le block.
	 */
	public Collection<List<String[]>> readFile() {
		List<List<String[]>> aReadFile = new LinkedList<List<String[]>>();
		List<String[]> block = new LinkedList<String[]>();
		String line;
		try {
			while((line = aFile.readLine()) != null) {
				if(!line.trim().equals("")) {
					String[] field = breakLine(line.trim());
					block.add(field);
				} else {
					if (block.size() > 0) {
						aReadFile.add(block);
						block = new LinkedList<String[]>();
					}
				}
			}
			
			if(block.size() > 0)
				aReadFile.add(block);
	
			return aReadFile;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * M�thode auxiliare. Cette m�thode re�oit une ligne provenient du fichier et la transforme
	 * � un tableau de deux positions 
	 * @param String - ligne lu du fichier
	 * @return String[] - Tableau composant par [Nome, valeur]
	 */
	private String[] breakLine(String line) {
		String[] field = new String[2];
		field[0] = line.substring(1, line.indexOf(" "));
		field[1] = line.substring(line.indexOf(" ") + 1);
		return field;
	}
}
