package util;


/**
 * Created by JMBRUN on 01/12/2016.
 */
public enum MessageEnum {

        ERR_UNKNOW("Erreur inconnue"),
        ERR_ARRAY_INPUT("Erreur : le tableau d'entrée est nul"),
        ERR_ARRAY_SIZE("Erreur : le tableau d'entrée ne contien pas suffisemment d'éléments"),
        ERR_COMPUTE("Erreur : il y a eu un problème, letableau de retour est vide"),
        ERR_NO_SOLUTION("Erreur : aucune solution n'a pu être calculée"),
        ;

        private final String label;

        public String getLabel() {
                return label;
        }

        MessageEnum (String pLabel) {
                this.label = pLabel;
        }

}

