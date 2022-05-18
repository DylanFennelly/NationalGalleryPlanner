package ng.plan.nationalgalleryplanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ng.plan.nationalgalleryplanner.ADTs.GraphNodeAdjList;
import ng.plan.nationalgalleryplanner.ADTs.Room;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class NGPRun extends Application {
    public static RoomStore ROOMS;

    public static class RoomStore {
        GraphNodeAdjList<Room> room1, room2, room4, room5, room6, room7, room8, room9, room10, room11, room12, room14, roomSunley,
                room15, room15s, room16, room17, room17a, room18, room19, room20, room21, room22, room23, room24, room25, room26, room27,
                room28, room29, room30, room31, room32, room33, room34, room35, room36, room37, room38, room39, room40, room41,
                room42, room43, room44, room45, room46, roomCentral, roomVestibule, roomBridge, room51,  room51a, room52, room53,
                room54, room55, room56, room57, room58, room59, room60, room61, room62, room63, room64, room65, room66;



        public void createRooms(){  //one time method to create all Rooms
            room1=new GraphNodeAdjList<>(new Room("Room 1","1","The Credit Suisse Exhibition: Raphael","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/raphael-image.jpg")));
            room2=new GraphNodeAdjList<>(new Room("Room 2","2","The Credit Suisse Exhibition: Raphael","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/raphael-image.jpg")));
            room4=new GraphNodeAdjList<>(new Room("Room 4","4","The Credit Suisse Exhibition: Raphael","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/raphael-image.jpg")));
            room5=new GraphNodeAdjList<>(new Room("Room 5","5","The Credit Suisse Exhibition: Raphael","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/raphael-image.jpg")));
            room6=new GraphNodeAdjList<>(new Room("Room 6","6","The Credit Suisse Exhibition: Raphael","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/raphael-image.jpg")));
            room7=new GraphNodeAdjList<>(new Room("Room 7","7","The Credit Suisse Exhibition: Raphael","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/raphael-image.jpg")));
            room8=new GraphNodeAdjList<>(new Room("Room 8","8","The Credit Suisse Exhibition: Raphael","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/raphael-image.jpg")));
            room9=new GraphNodeAdjList<>(new Room("Room 9","9","Venice 1530-1600","enetian painting in this period was dominated by Titian (Tiziano) and three family workshops, active both locally and internationally: those of Jacopo Tintoretto, Paolo Veronese and Jacopo Bassano. Veronese was renowned for his harmonious and decorative colour and brilliant illusionistic effects. His paintings won Titian’s praise and he attracted many commissions from the Venetian state, including paintings for the Doge’s Palace.\n" +
                    "\n" +
                    "By contrast, Tintoretto was initially criticised by his contemporaries for working too quickly which, they said, gave his paintings an unfinished look. But this technique enabled him to develop a dynamic style in which the rapid brushwork intensifies the dramatic impact of his daringly posed figures.\n" +
                    "\n" +
                    "Although Jacopo rarely left his home town Bassano on the Venetian mainland, he nonetheless attracted many patrons from Venice itself. He was famed for his depictions of biblical subjects, which he set in realistic rustic surroundings with vivid depictions of animals and rural life.",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/venice-image.jpg")));
            room10=new GraphNodeAdjList<>(new Room("Room 10","10","The sacred and profane in sixteenth-century Italian art","\n" +
                    "\n" +
                    "Representing some of the leading artists working in central and northern sixteenth-century Italy, the paintings in this room show the growing interest in this period for using art as a means of creative and intellectual expression. The prominence of sacred images for inspiring devotion remained hugely important, but artists also embraced the visual possibilities of secular subject matter drawn from mythological and classical sources. In this room, examples of both types of art can be seen by artists such as Bronzino, Correggio and Titian.\n" +
                    "\n" +
                    "Commissioning art based on complex allegory and obscure literature enabled wealthy patrons to demonstrate their cultural, political and intellectual acuity. The mythologies in this room – Bronzino’s enigmatic An Allegory with Venus and Cupid, Titian’s celebrated Bacchus and Ariadne, and Tintoretto’s The Origin of the Milky Way – are the result of artists cultivating relationships with an educated elite, whose tastes for these subjects provided an exciting new means of artistic experimentation beyond the realm of religious art.  \n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room10-image.jpg")));
            room11=new GraphNodeAdjList<>(new Room("Room 11","11","Veronese's 'Four Allegories of Love' ","\n" +
                    "\n" +
                    "The four paintings in this room are 'Allegories of Love' by Paolo Veronese, each concentrating on a specific aspect. In turn, they seem to deal with Unfaithfulness, ‘Scorn, Respect and Happy Union, although their precise meanings remain unclear and have been much debated. The costumes and hairstyles may indicate a date in the 1570s.\n" +
                    "\n" +
                    "They were probably made to decorate a ceiling and form a complete series. We do not know who commissioned them, but their presence in 1648 in the Prague Castle suggests that it may have been one of the Holy Roman Emperors, Ferdinand I (died 1564) or Maximilian II (died 1576), or a wealthy patron at the court. Alternatively, they may have been painted for a location in Venice, as two details from them are recorded in the famous sketchbook that Van Dyck kept in Italy between 1621 and 1627.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room11-image.jpg")));
            room12=new GraphNodeAdjList<>(new Room("Room 12","12","Northern Italian Portraiture 1510–1580","\n" +
                    "\n" +
                    "The paintings displayed in this room are predominantly portraits by Northern Italian artists and as such reflect one of the most important pictorial genres of the period. Regardless of the identity of the sitter, the primary function of a portrait was to capture likeness and inner virtue, denoting that the sitter was worthy of the honour of being portrayed and in time, remembered.\n" +
                    "\n" +
                    "Moretto and Moroni are among the finest representatives of the naturalistic approach that characterised 16th-century Lombard painting, and especially portraiture. Moretto worked primarily in Brescia, while his one-time student Moroni was the preeminent portraitist in Bergamo in the 1550s and 1560s, and after that in nearby Albino, his hometown. His portraits are characterised by acute psychological penetration, as well as great clarity of presentation.\n" +
                    "\n" +
                    "Lotto was one of the leading Venetian painters of the earlier 16th century, although he worked mainly outside Venice, in part because the competition for commissions there was so intense. This exposed him to a broad range of influences, from Lombard naturalism to Raphael’s High Renaissance Classicism. This might help explain why he is one of the most individualistic of the great Italian painters. His works are characterised by the use of deeply saturated colours and bold shadow, and his portraits are among the most empathetic of their time.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room12-image.jpg")));
            room14=new GraphNodeAdjList<>(new Room("Room 14","14","The Netherlands","\n" +
                    "\n" +
                    "Portraits by Netherlandish artists reveal a range of approaches to characterisation, from the delicacy of Catharina van Hemessen to the boldness of Lucas van Leyden and the frankness of Gossaert. Other pictures by artists of the period, such as Marinus van Reymerswaele, use some of the conventions of portraiture to make satirical observations. Pieter Bruegel the Elder is represented here by his tightly focused Adoration of the Kings, a masterpiece of speedy and skilful manipulation of oil paint, as well as an extraordinary study in characterisation.\n" +
                    "\n" +
                    "The room also includes examples of landscape painting, in which many Netherlandish artists specialised in this period.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room14-image.jpg")));
            roomSunley=new GraphNodeAdjList<>(new Room("Sunley Room","SR","Room closed","This room is currently closed to visitors.",null));
            room15=new GraphNodeAdjList<>(new Room("Room 15","15","","Room 15 is part of art route B and links Room 9 with Room 18 (Rubens) and on to our Dutch paintings including works by and Rembrandt and Van Dyck.",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room15-image.jpg")));
            room15s=new GraphNodeAdjList<>(new Room("Room 15 Stairs","15s","","", new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room15-image.jpg")));
            room16=new GraphNodeAdjList<>(new Room("Room16","16","Cranach the Elder, Huber and Seisenegger","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room16-image.jpg")));
            room17=new GraphNodeAdjList<>(new Room("Room 17","17","Altdorfer, Rottenhammer, Wertinger","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room17-image.jpg")));
            room17a=new GraphNodeAdjList<>(new Room("Room 17a","17a","Pastel in the 18th and 19th centuries","\n" +
                    "\n" +
                    "During the 18th century pastel as a medium for portraiture grew both in popularity and prestige. Extremely versatile, it could be used to depict fine detail or blended to create soft, luminous surfaces. Its ability to convey the smoothness of skin, the intricacy of hair and the textures of silk or velvet was unparalleled. In her portraits of European nobles Rosalba Carriera established pastel as a serious rival to oil. It became the medium of choice for Maurice-Quentin de la Tour and Jean-Etienne Liotard.\n" +
                    "\n" +
                    "In the late 19th century artists again turned to pastel as a medium, expanding its use far beyond portraiture. One of its most significant practitioners was Degas, who from the 1870s onwards increasingly favoured it over paint. In his studies of dancers and women at their toilet he continually refined his compositions by building up layers of colour. Towards the end of his career, the luminosity and tactile immediacy of the pastel medium allowed him to create astonishingly bold works of modern art.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room17a-image.jpg")));
            room18=new GraphNodeAdjList<>(new Room("Room 18","18","Rubens","\n" +
                    "\n" +
                    "Peter Paul Rubens, the most celebrated Flemish painter of Western art, was actually born in Germany to parents who had fled Antwerp because of their Protestant beliefs. In 1587 his family returned to Antwerp, where Rubens eventually converted to Catholicism. He had an enormously successful career as a learned painter of religious works expressing the Catholic reaction to the Reformation (the Counter-Reformation). Rubens was equally successful as a painter to the courts of Europe, including England, and on occasion worked as a diplomat. The ingenuity of his compositions, brilliant use of colour and his superb draughtsmanship made Rubens eminently suited to the task of dazzling audiences with the message of the Counter-Reformation. But he was equally determined to convey the stories and morals of Classical Antiquity.\n" +
                    "\n" +
                    "Rubens was by far the most successful painter of his day. Collectors flocked to buy his works, dazzled by his powers of invention. He could only meet this demand by employing many assistants, like the Italian Renaissance painters he admired. Patrons understood that a ‘Rubens’ would be designed by the artist, but might to some extent be painted by his pupils.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room18-image.jpg")));
            room19=new GraphNodeAdjList<>(new Room("Room 19","19","Dutch landscapes","\n" +
                    "\n" +
                    "Landscape has always played a vital role in painting. Until the 16th century this was almost exclusively as the (often imaginary) backdrop for biblical or mythological subjects. It was in 16th-century Flanders that landscape evolved into an independent genre. Flemish immigrant artists introduced these recent developments to the fledgling Dutch Republic. It is thus that a country characterised by an ostensibly uninspiring flat landscape, much of it not even rising above sea level, produced some of the greatest landscape painters in Western art.\n" +
                    "\n" +
                    "The Dutch flat landscapes stand in stark in contrast to the compositions of the so-called Italianate painters, painters who had travelled to Italy in the early 17th century and, after their return, continued to paint landscapes dominated by warm Mediterranean light and motifs. At mid-century, Jan Both initiated a new wave of Italianate landscape painting in Holland. His style was highly influential on a second generation of Dutch Italianate painters such as Nicholaes Berchem and others, some of whom may never have travelled to Italy themselves.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room19-image.jpg")));
            room20=new GraphNodeAdjList<>(new Room("Room 20","20","A different view of Flanders","\n" +
                    "\n" +
                    "Rubens’s landscapes present a different side of an artist who is best known for painting religious, mythological or classical subjects on commission. This room assembles a group of the artist’s landscapes, which he most probably painted for his own pleasure and that of a select group of friends. This meant that they remained largely hidden from view during Rubens’s lifetime. Soon after his death they became more widely known, and many eventually found their way to Britain, where they were greatly admired by artists such as Gainsborough and Constable. The former’s Watering Place and the latter’s Hay Wain (both in Room 34) are unthinkable without Rubens’s example.\n" +
                    "\n" +
                    "Portraits form yet another aspect of Rubens’s output and they illustrate how the artist moved in the circles of European monarchs, noblemen, connoisseurs, and scholars. By contrast, Jacob Jordaens portrayed almost exclusively people from his native city of Antwerp. In both his portraits and his historical and allegorical paintings, Jordaens introduced a level of realism that is alien to the religious and mythological works of Rubens and Van Dyck.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room20-image.jpg")));
            room21=new GraphNodeAdjList<>(new Room("Room 21","21","Van Dyck","\n" +
                    "\n" +
                    "Anthony van Dyck was a child prodigy who was already an accomplished artist by his mid-teens. After an apprenticeship with Hendrick van Balen, he entered Rubens’s studio to assist the master in painting biblical and mythological subjects, but Van Dyck is best known today for the grace and exuberance of his later portraits. Between 1621 and 1627 he made Italy his home, where he received important commissions from the aristocracy of Genoa and the bishops and cardinals of Rome. Back in Antwerp he was equally in demand as a portrait painter. Like Rubens, Van Dyck ran a large workshop in order to meet high demand, often leaving the less important parts of his portraits to studio assistants.\n" +
                    "\n" +
                    "King Charles I of England invited Van Dyck to London and knighted him in 1632. The artist became the ultimate visual chronicler of life at the English court, and to this day, his portraits of British aristocrats can be found in most major country house collections. Van Dyck’s elegant portraiture had a lasting influence on portrait painting throughout Europe, but nowhere more than in England.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room21-image.jpg")));
            room22=new GraphNodeAdjList<>(new Room("Room 22","22","Rembrandt","\n" +
                    "\n" +
                    "Rembrandt van Rijn aspired to be a painter of biblical and mythological subjects, which were held in higher regard than portraits. But portraiture was more profitable, and after settling in Amsterdam around 1631, Rembrandt enjoyed enormous success as a portrait painter. From the middle of the 17th century, his increasingly rough and brooding style of painting was out of step with a new fashion for smoothly painted and more evenly lit works. He nevertheless continued to receive portrait commissions from some of the most prominent people in the country, who remained impressed with his unparalleled skill in conveying character.\n" +
                    "\n" +
                    "Rembrandt frequently depicted specific models without intending them to be portraits. In these works (called 'tronies') he studied facial expressions or a stock character. Occasionally he would study his own face in such tronies, but he also depicted himself in more formal self-portraits. Rembrandt’s self-confidence is not only apparent from the fact that he invariably signed his works with his first name (Rembrandt), but also from the sheer number of works in which he painted his own likeness (some 40). It means we are now as familiar with his face as we are with his art.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room22-image.jpg")));
            room23=new GraphNodeAdjList<>(new Room("Room 23","23","Dutch portraiture","\n" +
                    "\n" +
                    "Dutch citizens from the newly affluent mercantile class were as keen to commission portraits of themselves and their families as were their aristocratic counterparts. In accordance with Calvinist tradition, Dutch sitters were mindful not to come across as too ostentatious, wearing predominantly black clothing and often posing in neutral surroundings. Their portraits therefore lack the showiness seen in Baroque portraits by artists such as Van Dyck (see Room 21). Yet the discerning observer would have understood that the refined if muted elegance of the sitter’s clothing signalled their high social status. What these portraits lost in swagger, they often gained in their vivid characterisation and intense focus.\n" +
                    "\n" +
                    "Portraits fulfil, first and foremost, a dynastic function and serve to remind us of the sitters’ position in society. It is in the hands of exceptionally talented artists, however, that portraits become great works of art. This is superbly exemplified by Frans Hals, whose bravura and assured painterly touch transport his portraits to a higher level.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room23-image.jpg")));
            room24=new GraphNodeAdjList<>(new Room("Room 24","24","International ambitions ","\n" +
                    "\n" +
                    "In spite of the decline in religious commissions in the Protestant Northern Netherlands, biblical or mythological subjects – traditionally considered the most elevated genre of painting – remained popular. The pan-European style of Mannerism, characterised by the exploration of the contorted human figure in daring poses, was also influential in the northern Netherlands, as seen in the works of Cornelis van Haarlem, Hendrik Goltzius and Joachim Wtewael. Artists from the predominantly Catholic city of Utrecht followed in the footsteps of Caravaggio, whose celebrated works they had studied during trips to Italy.\n" +
                    "\n" +
                    "Unlike them, Rembrandt never travelled to Italy, but his handling of light and dark and the unremitting naturalism of his history paintings reveal the influence of Caravaggio. Rembrandt became one of the most famous painters of his day, running a large workshop, where his pupils followed the master’s powerful example. His penetrating exploration of the human face ensured his position as one of the most sought-after portraitists of his time (see Room 22).\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room24-image.jpg")));
            room25=new GraphNodeAdjList<>(new Room("Room 25","25","A New Art For A New Nation (2)","Room 25 expands on the theme of Room 28; displaying prime examples of what were newly independent artistic genres, including landscape, still life, portraiture and scenes of 17th-century Dutch domestic life.",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room25-image.jpg")));
            room26=new GraphNodeAdjList<>(new Room("Room 26","26","Brueghel the Elder, van der Heyden, van de Velde","",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room26-image.jpg")));
            room27=new GraphNodeAdjList<>(new Room("Room 27","27","de Hooch, Saenredam, Vermeer","",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room27-image.jpg")));
            room28=new GraphNodeAdjList<>(new Room("Room 28","28","A New Art For A New Nation (1)","\n" +
                    "\n" +
                    "The Dutch Republic in the 17th century witnessed one of the most powerfully creative periods in Western art. In the late 16th century, the predominantly Protestant northern Netherlands declared itself independent from Catholic Spanish rule. A new art was born as artists increasingly produced works not on commission but for a speculative market determined by the demands of a new class of prosperous citizens.\n" +
                    "\n" +
                    "Pictures of traditional biblical and historical subjects (often called ‘history paintings’) persisted in the Republic. They were especially important for Rembrandt and his followers (see Rooms 24 and 27). Yet, increasingly these had to share the stage with several newly independent artistic genres, which had been pioneered by Flemish artists who had fled to the northern Netherlands to escape persecution by the Catholic authorities.\n" +
                    "\n" +
                    "Assembled in Rooms 28, 25 and 27 are prime examples of those genres, including landscape, still life, portraiture and scenes of domestic life. 17th-century Dutch pictures are often called ‘realistic’, but these seemingly lifelike scenes owe as much to the inventive skills of their painters as any history painting.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room28-image.jpg")));
            room29=new GraphNodeAdjList<>(new Room("Room 29","29","French Painting 1600–1700 ","\n" +
                    "\n" +
                    "In the 17th century, political ambitions to make of Paris a new Rome resulted in more French-born painters making their careers in the French capital. This trend was encouraged by the founding in 1648 of a royal academy of the arts, and by many wealthy individuals refurbishing their homes. Paintings such as Philippe de Champaigne’s full-length portrait of Cardinal de Richelieu make manifest the increasing power and self-confidence that was felt in France in this period. \n" +
                    "\n" +
                    "The most important French painter of the 17th century, however, did not live in Paris. Nicolas Poussin settled in Rome in 1624, where his style was shaped primarily by antique and Renaissance art. Poussin adapted Titian’s loose brushwork and harmonious colouring, often arranging his figures in a triangular composition. From about 1630, he took greater inspiration from paintings by Raphael and from antique sculpture. In The Adoration of the Golden Calf, for example, his figures are arranged frieze-like across the surface of the picture.\n" +
                    "\n" +
                    "Claude Gellée, also known as Claude Lorrain, was the most successful landscape painter of the 17th century. Among his patrons were numerous members of European nobility, including Philip IV of Spain and Pope Urban VIII. Claude specialised in idealised landscapes and port scenes, in which he often mixed the real with the fictive. His great innovation was painting the sun facing the viewer.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room29-image.jpg")));
            room30=new GraphNodeAdjList<>(new Room("Room 30","30","Spain","Spanish painting flourished during the 17th century principally in the service of God and King. The evolution of a Catholic Counter-Reformation religiosity is revealed in a variety of powerful, individual styles. Not long after El Greco had portrayed the divine with ethereal idealisations of figures, space and light, Diego Velázquez and Francisco de Zurbarán turned to realism to represent the mystical.\n" +
                    "\n" +
                    "To make religion more personally relevant, they used naturalistic light to convey divine presence and they depicted the saints as ordinary people, with a vivid physicality and facial expressions. Taste changed after 1650, and Bartolomé Esteban Murillo appealed to popular piety with an ideal style of soft forms and colours, and a sweet and gentle mood.\n" +
                    "\n" +
                    "At the court of Philip IV, Velázquez transformed his style of earthy realism in order to express the dignity and splendour of the monarchy. He developed an elegant technique of artful brushwork that calls attention to itself and yet conveys compelling actuality when viewed from a distance.",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room30-image.jpg")));
            room31=new GraphNodeAdjList<>(new Room("Room 31","31","Room closed","This room is currently closed to visitors.",null));
            room32=new GraphNodeAdjList<>(new Room("Room 32","32","17th-century Italian paintings","\n" +
                    "\n" +
                    "At the turn of the 17th century, two differing styles emerged in Italy that were to affect the future of painting across Europe. One was idealised and classicising, as demonstrated by the works of Annibale Carracci and Guido Reni, and the other, introduced by Caravaggio, was powerfully naturalistic.\n" +
                    "\n" +
                    "Although profoundly different, both styles were based on a return to the study of nature. What emerged from these two different approaches are the characteristics of the Baroque – dynamic compositions, dramatic lighting, vivid use of colour and intense expression of emotion. These are evident in the paintings hanging in this room, most of which were commissioned to adorn the palaces of wealthy patrons in Rome, Florence, Bologna, Naples and Genoa.\n" +
                    "\n" +
                    "In 2013 twenty-five paintings from the collection of the distinguished art historian Sir Denis Mahon (1910–2011) were presented to the National Gallery through Art Fund. The breadth and quality of the Italian Baroque collection have been greatly enhanced by this bequest, which includes works by Domenichino, Giordano, Guercino and Reni.\n" +
                    "\n" +
                    "Room 32, where the Italian Baroque paintings are displayed, is the largest gallery in the building. In July 2020 the room reopened to the public after a major renovation programme, made possible through the generous support of Julia and Hans Rausing. The purpose of this project was to reinstate the original decorative scheme of its architect, Edward M. Barry (1830-1880). The dark red wall cloth, ornate painted frieze and lunettes, whose designs alternate winged lions with dolphins, have all been reinstated according to the original colour scheme.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room32-image.jpg")));
            room33=new GraphNodeAdjList<>(new Room("Room 33","33","David, Fragonard and Vernet","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room33-image.jpg")));
            room34=new GraphNodeAdjList<>(new Room("Room 34","34","Constable, Turner and Stubbs","\n" +
                    "\n" +
                    "By the second half of the 18th century, British society portraits by Thomas Gainsborough and Joshua Reynolds were painted on a grand scale in the European manner. George Stubbs’s equivalent representations of heroic racehorses were, however, uniquely British. Other family and group portraits by William Hogarth and Joseph Wright of Derby reflect more traditional preoccupations with mortality.\n" +
                    "\n" +
                    "British painters also developed highly innovative approaches to landscape painting, while always keeping note of a wider European tradition. Gainsborough looked back to Rubens, while Turner drew on his knowledge of Dutch marine painting and of the French painter Claude. Yet both went on to develop free and personal styles of painting, in which the depiction of light was paramount.\n" +
                    "\n" +
                    "Constable’s novel approach to landscape was received with more\n" +
                    "enthusiasm in France than in England. His large-scale paintings of rural\n" +
                    "scenes, based on oil sketches, elevated the recording of the immediacy of effects of light and weather to a new plane.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room34-image.jpg")));
            room35=new GraphNodeAdjList<>(new Room("Room 35","35","Hogarth and British Painting","\n" +
                    "\n" +
                    "William Hogarth, the leading British painter of the early 18th century, was determined that his fellow artists should be seen as the equals of their European contemporaries. His paintings of such subjects as Marriage A-la-Mode were reproduced as commercially successful engravings, but his rich and subtle characterisation is most fully evident in the original paintings. Hogarth’s portraits also vividly demonstrate his skilful and economical painting technique, especially his images of colourful characters observed on the streets of London.\n" +
                    "\n" +
                    "Joseph Wright of Derby, Thomas Gainsborough and George Stubbs all painted fashionable members of society in landscape settings. Such paintings might celebrate a union between two families and sometimes the consequent acquisition of land. Gainsborough’s portrait of his family follows a conventional format but in depicting his daughters, for example, he showed off a new creative freedom. His extraordinarily assured painting technique conveys a directness and sympathy for his subject.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room35-image.jpg")));
            room36=new GraphNodeAdjList<>(new Room("Room 36","36","Claude and Turner","Two works by the 19th-century English painter Turner are hung in this room with two by the 17th-century French landscape painter Claude, in accordance with Turner’s will.\n" +
                    "\n" +
                    "When Turner died in 1851, he left to the National Gallery Dido building Carthage and Sun rising through Vapour on condition that they were hung ‘always between the two pictures painted by Claude’, which he named as 'The Seaport' and 'The Mill'.\n" +
                    "\n" +
                    "The pictures within each pair are very different from one another in subject and mood. Turner may have deliberately chosen to make contrasting works so as to mirror the differences between the two pictures by Claude. By doing so, he could also perhaps avoid the sense that he was merely copying the earlier master’s work.",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room36-image.jpg")));
            room37=new GraphNodeAdjList<>(new Room("Room 37","37","The Grand Tour","\n" +
                    "\n" +
                    "By the eighteenth century, the Grand Tour had become an established part of a young aristocrat’s education. Lasting anywhere from several months to several years, a Grand Tour voyage involved visiting the great sites and monuments of Europe. Italy held a particular allure, combining the treasures of classical antiquity with the more recent artistic achievements of the Old Masters.  \n" +
                    "\n" +
                    "Many artists responded to the market created by these wealthy visitors. In Rome, Pompeo Girolamo Batoni became the portrait painter of choice for British Grand Tourists, often depicting his sitters alongside the works of classical antiquity they had travelled to admire. Other artists, such as Canaletto in Venice and Giovanni Paolo Panini in Rome, painted souvenir views of their respective cities. Bernardo Bellotto was unusual for enacting a Grand Tour in reverse, taking the meticulous and evocative mode of view painting he had learned in his uncle Canaletto’s studio to the court cities of northern Europe.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room37-image.jpg")));
            room38=new GraphNodeAdjList<>(new Room("Room 38","38","Canaletto and Guardi","\n" +
                    "\n" +
                    "Paintings portraying the grandeur of Venice became popular at the dawn of modern tourism. British visitors on the Grand Tour created a demand for view paintings of celebrated sights and Venetian festivals to take home with them. Many gentlemen – so-called milordi – sought the works of Giovanni Antonio Canal, better known as Canaletto. His views went beyond topographical accuracy to capture the poetic play of light, water and architecture, unique to the experience of Venice. Prompted by declining tourism, in 1746 Canaletto moved to England, where he painted views of London, Oxford and other cities as well as the country seats of his patrons.\n" +
                    "\n" +
                    "Canaletto’s successor in Venice, Francesco Guardi, brought a greater range of expression to view painting, stressing the atmospheric play of light and the frenetic activity of the city with elegant, free brushwork. \n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room38-image.jpg")));
            room39=new GraphNodeAdjList<>(new Room("Room 39","39","Canaletto, Pittoni, and Tiepolo","\n" +
                    "\n" +
                    "Although no longer the powerful maritime empire it had been in previous centuries, Venice remained a prosperous trading place and a centre for the visual arts until the decline of the Venetian Republic at the end of the 18th century.\n" +
                    "\n" +
                    "Canaletto became the most sought-after painter of Venetian views, capturing the spirit of the city in his evocative paintings. Giovanni Battista Tiepolo initiated a second renaissance in Venetian art with his bright and vibrant colours: his imaginative frescoes and canvases became the new fashion for the decoration of the many palaces, churches and villas. Giovanni Battista Pittoni was one of the painters deeply affected by the work of Tiepolo and, through his many commissions from abroad, Pittoni played an important role in the international success of the Venetian Rococo style.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room39-image.jpg")));
            room40=new GraphNodeAdjList<>(new Room("Room 40","40","18th-century painting in Europe","During the 18th century it was common for artists to travel, both to seek inspiration and embrace opportunity. Claude-Joseph Vernet was the most celebrated French view painter of the period. In 1734 he relocated to Rome, where he spent almost 20 years and earned an international reputation. Vernet’s view paintings (or ‘vedute’) were particularly sought after by travellers on the and European rulers. His contrasting pair of paintings, A Landscape at Sunset and A Shipwreck in Stormy Seas, were originally commissioned for the King of Poland, Stanislaus Augustus Poniatowski (1732–1798), whose official court painter at the time was Bernardo Bellotto. Having trained with his uncle Canaletto in Venice, Bellotto went on to enjoy a successful career at the royal courts in Dresden, Vienna, Munich and Warsaw, glorifying the great capitals of Europe through his highly original topographical views.",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room40-image.jpg")));
            room41=new GraphNodeAdjList<>(new Room("Room 41","41","Cézanne, Monet, Renoir","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room41-image.jpg")));
            room42=new GraphNodeAdjList<>(new Room("Room 42","42","Room Closed","This room is currently closed to visitors.",null));
            room43=new GraphNodeAdjList<>(new Room("Room 43","43","Gauguin, Seurat, Van Gogh","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room43-image.jpg")));
            room44=new GraphNodeAdjList<>(new Room("Room 44","44","Cézanne, Degas, Monet","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room44-image.jpg")));
            room45=new GraphNodeAdjList<>(new Room("Room 45","45","Constable, Corot and Ingres","",new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room45-image.jpg")));
            room46=new GraphNodeAdjList<>(new Room("Room 46","46","Room Closed","This room is currently closed to visitors.",null));
            room51=new GraphNodeAdjList<>(new Room("Room 51","51","Italy, 1250–1350","\n" +
                    "\n" +
                    "The earliest works in the National Gallery’s collection are displayed in this room. Like most paintings of this period, they were intended for Christian worship.They were painted as altarpieces, to decorate the fronts of altars, or as crucifixes to hang in church interiors. Churchmen and women, and members of the social elite, owned small images of Christian subjects to stimulate private prayer and devotion; an outstanding example of which is The Wilton Diptych.\n" +
                    "\n" +
                    "Italian painting of this period is indebted to the art of the Byzantine Empire. Byzantine icons (sacred images of Christ, the Virgin Mary and the saints) were venerated across the Italian peninsula. Their gilded backgrounds and deep colours were an inspiration to many painters. So, too, were the subjects they depicted. For instance, the depiction of Christ as the Man of Sorrows – first developed in Byzantine art of the 12th century – was much copied in Italy.\n" +
                    "\n" +
                    "In the late 13th and early 14th centuries, painters across Italy strove to inject a new, naturalistic spirit into painting. Cimabue, for instance, shows the Christ Child as a real baby, clinging to his mother’s hand. Giotto, who may have been Cimabue’s pupil, gives his figures monumentality and gravity, often placing them within convincing architectural spaces.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room51-image.jpg")));
            room51a=new GraphNodeAdjList<>(new Room("Room 51a","51a","Fra Angelico, friar-painter of San Domenico","\n" +
                    "\n" +
                    "Around 1420, the painter Guido di Pietro took holy orders and entered the recently revitalised Observant Dominican convent in Fiesole, outside Florence. Adopting the name Fra Giovanni, he soon embarked on the first of many artistic projects for his community: an altarpiece for the high altar of their convent church, San Domenico.\n" +
                    "\n" +
                    "The panels displayed in this room were part of the San Domenico altarpiece. Around 75 years after it was painted, this altarpiece was adapted by another Florentine painter, Lorenzo di Credi. He converted the central arched panels into a single-field rectangular image and replaced the gold backgrounds with a painted sky and landscape. The predella was left untouched, remaining in the church until the early 19th century, when it was sold.\n" +
                    "\n" +
                    "Updating earlier altarpieces was not unheard of during this period. However, changing taste was more typically accommodated by simply replacing old-fashioned works. The decision to retain and adapt this altarpiece may reflect Fra Giovanni’s revered reputation at San Domenico. Within only a few years of his death in 1455, he was called Angelico (the angelic one) in poetic response to his achievements as theologian-painter.\n"
                    ,new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room51a-image.jpg")));
            room52=new GraphNodeAdjList<>(new Room("Room 52","52","Siena, 1300–1450","\n" +
                    "\n" +
                    "In the late Middle Ages the Republic of Siena was one of Europe’s smallest but wealthiest states. Siena’s political independence, however, was precarious. Its people believed it was the result of the decisive intervention of the Virgin Mary in a battle against Florence, Siena’s deadliest enemy, in 1260.\n" +
                    "\n" +
                    "The city made the Virgin Mary its queen, and in 1308 commissioned its greatest painter, Duccio, to make a large, double-sided altarpiece called the Maestà in her honour, for the high altar of Siena’s cathedral. The front shows the Virgin and Child in the court of Heaven, while the back – visible only to the clergy – tells 40 episodes from Christ’s life.\n" +
                    "\n" +
                    "Several paintings from the Maestà, which was dismantled in the 18th century, are shown in this room. It became the key reference point for all subsequent Sienese painters. They admired Duccio’s evocation of Byzantine icons, his elegant use of colour, line and pattern, and also his experimentation. His pictures have a sense of depth and space that marks a turning point in Western painting.\n" +
                    "\n" +
                    "Duccio’s followers, who included Simone Martini, Pietro and Ambrogio Lorenzetti and Ugolino di Nerio, developed his innovations in different ways. Sienese painting was prized and copied all over Europe – even in Florence.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room52-image.jpg")));
            room53=new GraphNodeAdjList<>(new Room("Room 53","53","Florence and Beyond, 1440–1470","\n" +
                    "\n" +
                    "In the middle decades of the 15th century, artists in Florence and its surrounding territories diversified their production to meet the desires of patrons seeking new kinds of art to adorn their residences. Uccello’s Battle of San Romano, which celebrated a recent military victory, was part of an exceptionally ambitious commission for the Bartolini Salimbeni family palace. Smaller works treating ancient of mythological subjects also had a commemorative function, often marking an important event such as a wedding or a birth.\n" +
                    "\n" +
                    "Pisanello, painting for patrons in the ducal courts of northern Italy, employed ostensibly Christian subjects as a pretext for lavish depictions of hunting and knightly pursuits associated with courtly life. Such chivalric associations likely also inspired Uccello’s Saint George and the Dragon.\n" +
                    "\n" +
                    "Religious faith, however, remained the driving force behind most artistic commissions. Both the paintings by Piero della Francesca in this room formed part of altarpieces for churches in his native Borgo San Sepolcro. Christian imagery was found in civic spaces too. Saint Bernard’s Vision by Filippo Lippi was displayed in Florence’s government headquarters and Domenico Veneziano’s pair of saints are fragments of a frescoed shrine found on the city’s streets.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room53-image.jpg")));
            room54=new GraphNodeAdjList<>(new Room("Room 54","54","Mantegna and Crivelli","\n" +
                    "\n" +
                    "Andrea Mantegna’s unrivalled ability to bring the lost worlds of ancient Greece and Rome to life brought him enduring fame. Born into relative poverty, Mantegna spent over 45 years as court artist to the Gonzaga family, the sophisticated rulers of Mantua. His powers of invention, mastery of illusionism and exceptional talent as a draughtsman dazzled his patrons and his fellow artists.\n" +
                    "\n" +
                    "Like Mantegna, the Venice-born painter Carlo Crivelli trained in the university city of Padua, at the ‘Art Academy’ run by the painter Squarcione. After working on both sides of the Adriatic Sea, Crivelli settled in the mountainous region of the Marche in central Italy. The originality of his works, which blend the real and the fantastical, derives from his ability to incorporate into his paintings elements inspired by the artistic cultures of these various places.\n" +
                    "\n" +
                    "The works in this room all date to the latter phases in both painters’ careers and showcase their distinctly different styles. Nonetheless, they also reveal how certain characteristics of their shared Paduan formation endured: virtuosity in the depiction of stone and still life elements, a predilection for bold spatial design and classical motifs and the use of strong, black outlines to give forms a chiselled sharpness.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room54-image.jpg")));
            room55=new GraphNodeAdjList<>(new Room("Room 55","55","Venice and the Veneto, 1460–1510","\n" +
                    "\n" +
                    "During the second half of the 15th century, the Republic of Venice was one of Europe’s most important and populous centres. Venice’s merchants and navy controlled almost all Western trade in the Eastern Mediterranean. In completion with the Ottoman Turks, who had conquered Constantinople in 1453, Venice laid claim to the former territories of the Byzantine Empire.\n" +
                    "\n" +
                    "Venetian paintings of this period reflect a taste that was shaped by the city’s international connections. Art in the Byzantine style, notably the mosaics that adorned the Basilica of San Marco, provided the bedrock of Venetian painting. Contemporary Northern European pictures, particularly by Jan van Eyck, Dirk Bouts and Hans Memling, were avidly collected by Venetians. They admired their mastery of painting in oil, and their precise rendering of naturalistic detail. In the mid-1470s, when the Southern Italian painter, Antonello da Messina, visited Venice, his Netherlandish-inspired art made a sensation.\n" +
                    "\n" +
                    "For much of this period, the Bellini family ran the city’s most important painting workshop, supplying everything from manuscript illuminations to large-scale altarpieces. While Gentile Bellini was the official portraitist to successive Doges of Venice, his younger brother, Giovanni, was a more talented artist. His skill as a painter of atmospheric, light-filled landscapes paved the way for an entire generation of artists, including Giorgione and Titian.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room55-image.jpg")));
            room56=new GraphNodeAdjList<>(new Room("Room 56","56","Venice after 1500","\n" +
                    "\n" +
                    "In the early 1500s, painting in Venice witnessed a fervour of experimentation, as artists developed distinctive approaches to light and colour, emphasising atmosphere, mood and the sense of physical presence.\n" +
                    "\n" +
                    "Giorgone, and later Titian, were key figures in this development. In Giorgione’s Tramonto (the sunset) the setting is dreamlike though the atmospheric effects are observed from nature, while Titian’s Noli Me Tangere sets the Biblical story in a misty morning landscape of the kind viewers would recognise from the Venetian mainland.\n" +
                    "\n" +
                    "The interest amongst educated patrons for humanist subjects combining allegorical content and poetic effect grew alongside the ongoing demand for small religious paintings for private prayer. The meticulously painted examples here by Cima and Catena were intended to elicit devotion through close looking.\n" +
                    "\n" +
                    "Greater attention to evoking sensual reality also manifested itself in portraiture, which became more animated and thereby suggestive of the sitter’s character and psychological state.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room56-image.jpg")));
            room57=new GraphNodeAdjList<>(new Room("Room 57","57","Ferrara and Bologna","\n" +
                    "\n" +
                    "The cities of Ferrara and Bologna flourished as centres of artistic excellence from the late fifteenth and throughout the following century. In Ferrara, the ruling Este dukes cultivated the idiosyncratic talents of several generations of painters, employing a succession of official court artists. The first was Cosme Tura, whose paintings are characterized by melancholic figures, angular draperies and fantastical details. His Virgin and Child Enthroned on display in this room became a blueprint for altarpiece design in the region. \n" +
                    "\n" +
                    "Tura’s dominion in Ferrara meant that several of his most talented compatriots sought patronage nearby in the great university city of Bologna. Francesco del Cossa and Ercole de’ Roberti worked extensively there. Later, when Ercole returned to Ferrara to replace Tura as court painter, Lorenzo Costa rose to pre-eminence. He and Francesco Francia, a Bologna native, collaborated on prestigious commissions for the ruling Bentivoglio clan. Both were gifted portrait painters too. \n" +
                    "\n" +
                    "In Mantua, where Costa later became court artist to the Gonzaga dukes, the young painter Dosso Dossi likely came under his tutelage. Dosso went on to a distinguished career as court painter in Ferrara, where his luminous colouring and expressive approach to the figure suited the sophisticated and extravagant tastes of the Este dukes.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room57-image.jpg")));
            room58=new GraphNodeAdjList<>(new Room("Room 58","58","Botticelli and Filippino Lippi","Sandro Botticelli was among the most sought-after painters in his native Florence in the last three decades of the fifteenth century. A versatile and creative artist, he produced paintings of many types from large scale altarpieces and mythological scenes, to smaller devotional images and portraits. Filippino Lippi was the son of Botticelli’s teacher, Fra Filippo Lippi. Following the death of his father when he was still a boy, Filippino entered Botticelli’s workshop. \n" +
                    "\n" +
                    "There are three works in this gallery depicting the Adoration of the Kings: one a collaboration between the two painters, one a large scale tondo (circular painting) by Botticelli and one painted by Filippino after he had begun working as an independent master. The Adoration was an enormously popular subject among Florentines loyal to the ruling Medici family. The Medici strongly identified with the kings and organised a lavish procession on Epiphany, the feast day of the kings. \n" +
                    "\n" +
                    "All the works in this room were commissioned by private patrons, mostly for display inside their homes.",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room58-image.jpg")));
            room59=new GraphNodeAdjList<>(new Room("Room 59","59","Florence, 1460–1500","\n" +
                    "\n" +
                    "The baton of power passed between four generations of Medici in Florence in the second half of the 15th century. They even survived a dramatic attempted coup in 1478, which saw the assassination of Giuliano, beloved brother of Lorenzo the Magnificent. The family’s grip on power was only loosened following Lorenzo’s death in 1492. His son and heir was soon forced into exile and the republic was restored. \n" +
                    "\n" +
                    "The Medici and their allies used artistic commissions to bolster their prestige and political clout, promoting a succession of pioneering Florentine artists. Verrocchio and the Pollaiuolo brothers ran large, prolific workshops, where artists worked collaboratively. Each took inspiration from classical antiquity, theories of perspective, and the detailed landscapes of contemporary Northern European artists. \n" +
                    "\n" +
                    "The paintings in this room reflect the enduring Florentine enthusiasm for devotional images, both altarpieces made for family chapels in public churches and smaller works for the home. The city’s painters were also sought after by patrons in other cities, like the Duke of Milan, Ludovico Sforza. He commissioned Perugino, an Umbrian painter who was based in Florence in the 1490s, to paint an altarpiece for the Charterhouse at Pavia, in Lombardy. \n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room59-image.jpg")));
            room60=new GraphNodeAdjList<>(new Room("Room 60","60","Florentine Altarpieces about 1350 – about 1460 ","\n" +
                    "\n" +
                    "Altarpieces were among the most ambitious works of art made in Florence during the period known today as the Early Renaissance. Standing on the altars of churches, private chapels and convents, they provided a backdrop for the celebration of Mass, when the bread and wine are consecrated. Altarpieces were commissioned by a wide variety of patrons, from wealthy citizens and high-ranking clerics, to religious institutions and corporate groups such as guilds.\n" +
                    "\n" +
                    "Florentine altarpieces varied considerably in size and construction. Jacopo di Cione’s San Pier Maggiore ‘polyptych’, a multi-panelled ensemble originally set within an ornate architectural frame, exemplifies the most popular altarpiece type of the 14th century. Later, this format was superseded with the innovation of a single-field, spatially unified image, such as Francesco Pesellino’s Santa Trinità Altarpiece.\n" +
                    "\n" +
                    "Most of the paintings in this room are fragments of larger altarpieces. Many of them come from religious institutions that were suppressed in the eighteenth and nineteenth centuries. At this time, altarpieces were often cut into pieces and sold as separate art works. Today they are scattered in museums and collections around the world.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room60-image.jpg")));
            room61=new GraphNodeAdjList<>(new Room("Room 61","61","Central Italy, 1480–1520","\n" +
                    "\n" +
                    "The artists represented in this room experimented with depicting the body and employing colour in dynamic ways in the decades around the turn of the sixteenth century.\n" +
                    "\n" +
                    "Luca Signorelli was prolific across both Umbria and Tuscany. His particular interest in showing the human form in all its robust naturalism served as inspiration for his younger contemporary, Michelangelo.\n" +
                    "\n" +
                    "First apprenticed as a painter in the workshop of Domenico Ghirlandaio in Florence, Michelangelo then trained as a sculptor under the patronage of Lorenzo de’ Medici. The National Gallery holds two of his rare surviving panel paintings, both unfinished and dating from his early years working between Florence and Rome.\n" +
                    "\n" +
                    "Michelangelo, in turn, greatly influenced the Florentine artist Pontormo. Active in the first half of the sixteenth century, Pontormo studied under various painters, including Piero di Cosimo. His paintings depicting the Story of Joseph are prime examples of his innovative compositions, vivid use of colour and distinctive figure types.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room61-image.jpg")));
            room62=new GraphNodeAdjList<>(new Room("Room 62","62","Cologne and north-western Germany","\n" +
                    "\n" +
                    "Cologne was one of the most prosperous cities in 15th-century Germany. Its numerous churches were filled with paintings produced by its large population of painters. Some of these came from other towns to work in Cologne: Stephan Lochner, whose name is associated with a charming and technically accomplished style, was originally from southern Germany. The witty painter, the Master\n" +
                    "of the Saint Bartholomew Altarpiece, a native of the northern Netherlands, produced a number of works for the Carthusian monastery in Cologne.\n" +
                    "\n" +
                    "East of Cologne in Westphalia, the painter identified only as the Master of Liesborn established a large workshop in the latter part of the 15th century, supplying altarpieces to the numerous ecclesiastical foundations near Münster, many of which were being reformed. They included the Benedictine Abbey of Liesborn. The Master of Liesborn began a large winged altarpiece for the high altar, but it was completed by another painter, Jan Baegart.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room62-image.jpg")));
            room63=new GraphNodeAdjList<>(new Room("Room 63","63","15th-century Netherlandish painting","\n" +
                    "\n" +
                    "Painters in the Low Countries in the early 15th century such as Jan van Eyck and Rogier van der Weyden achieved a technical mastery of the medium of oil paint which they deployed with extraordinarily skill. It made them – and their successors – famous throughout Europe.\n" +
                    "\n" +
                    "In large altarpieces as well as the small devotional paintings and portraits exhibited here these painters suggested realities by their ability to paint the effects of light both indoors and outside.\n" +
                    "\n" +
                    "Jan van Eyck worked in Bruges, with its large population of Italian merchants, from whom he drew some of his clientele; Petrus Christus also worked in Bruges. Robert Campin was based in Tournai, while Rogier van der Weyden worked in Brussels, and was painter to the Burgundian court there. Dirk Bouts in Leuven (Louvain), Hans Memling in Bruges and Hieronymus Bosch in ‘s-Hertogenbosch were highly accomplished painters with an international clientele.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room63-image.jpg")));
            room64=new GraphNodeAdjList<>(new Room("Room 64","64","Beyond the Netherlands","\n" +
                    "\n" +
                    "Paintings from the Netherlands were exported all over Europe in the 15th century. Painters trained in the Netherlandish use of oil paint were much in demand for their ability to represent dazzling effects of light, penetrating portraits, and lyrical landscapes.\n" +
                    "\n" +
                    "In Spain Bermejo’s mastery of the oil painting technique was second to none, but the origin of his training is unknown. Juan de Flandes, a Netherlandish artist, was painter to Queen Isabella of Spain, who also commissioned work from Michel Sittow, a native of Tallinn in Estonia working in the Netherlandish tradition. In Italy Duke Federico of Urbino commissioned Justus of Ghent to decorate his study with learned allegories, two of which are shown here.\n" +
                    "\n" +
                    "Leading painters in France were either natives of the Netherlands or trained there: Jean Hey travelled south to work for the Duke and Duchess of Bourbon in central France, while the Master of Saint Giles was probably based in Paris.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room64-image.jpg")));
            room65=new GraphNodeAdjList<>(new Room("Room 65","65","Southern Germany and Austria","Painters in southern German and Austria collaborated with sculptors to produce spectacular large altarpieces with moveable shutters. One of the greatest specialists in such work was Michael Pacher from the Tyrol. The small devotional painting of the Virgin and Saints attributed to him reflects the daring illusionistic effects he achieved in large-scale altarpieces.\n" +
                    "\n" +
                    "Working in Nuremberg from the end of the 15th century, Albrecht Dürer undertook the traditional range of work, including the large painting of the Virgin probably produced under his supervision, and small devotional paintings such as the Saint Jerome. Its extraordinary sympathy for the natural landscape and spectacularly imaginative reverse demonstrates the extent of Dürer’s innovations as a painter. Dürer was also a successful portraitist, extending the tradition of elegantly designed and psychologically acute representations exemplified here by the portraits of a woman of the Hofer family and of Alexander Mornauer.",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room65-image.jpg")));
            room66=new GraphNodeAdjList<>(new Room("Room 66","66","Leonardo da Vinci at the National Gallery","\n" +
                    "\n" +
                    "Leonardo da Vinci is one of the towering figures of Western art.\n" +
                    "\n" +
                    "Born in humble circumstances, Leonardo ended his life as ‘first painter and engineer’ to the French King Francis I. His achievements as an artist, architect, designer, theorist, engineer and scientist are little less than astonishing. Though many of his works were never finished, Leonardo influenced generations of artists. Leonardo trained as a painter and sculptor in the Florentine workshop of Andrea del Verrocchio. There he perfected the exceptional talent for drawing that was key to his artistic and intellectual endeavours.\n" +
                    "\n" +
                    "In 1483 Leonardo moved to Milan, ruled by Duke Ludovico Sforza, hoping to find work as an engineer and scientist. Yet his first Milanese commission was a painting, The Virgin of the Rocks. It was conceived as the central panel of an altarpiece for the chapel of the Confraternity of the Immaculate Conception, attached to the church of San Francesco. For reasons that remain unclear, the confraternity rejected Leonardo’s first painting (now in the Musée du Louvre, Paris). The National Gallery’s version of The Virgin of the Rocks, begun in the early 1490s, was only completed between 1506 and 1508. Two more paintings from the Immaculate Conception altarpiece, by associates of Leonardo, are displayed in this room.\n" +
                    "\n" +
                    "Leonardo left Milan in 1499, shortly after French troops invaded the city, and returned to Florence. The Burlington House Cartoon dates to this turbulent period. Leonardo is known to have made several life-size works on paper (often called cartoons), but this is the only such drawing to survive. It will have been made in preparation for a painting, but Leonardo probably viewed it as a work of art in itself. Huge crowds flocked to see a similar cartoon by Leonardo, when it was put on public display in Florence in 1501.\n",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/room66-image.jpg")));
            roomCentral=new GraphNodeAdjList<>(new Room("Central Hall","CH","","",null));
            roomVestibule=new GraphNodeAdjList<>(new Room("Main Vestibule","MV","Main Vestibule","The Main Vestibule, just beyond the Portico entrance, leads up the stairs to Central Hall, Room 1 and the galleries on the main floor. Boris Anrep's mosaics were added in the 1920s and 30s, depicting leading figures of the day as characters from mythology.",
                    new Image("src/main/java/ng/plan/nationalgalleryplanner/roomImages/roomMV-image.jpg")));
            roomBridge=new GraphNodeAdjList<>(new Room("Bridge to Sainsbury Wing","BR","","",null));





































        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        ROOMS = new RoomStore();

        Parent p = FXMLLoader.load(Objects.requireNonNull(NGPRun.class.getResource("main-view.fxml")));
        Scene scene = new Scene(p);
        stage.setTitle("National Gallery Route Planner");
        stage.setScene(scene);
        stage.show();

        boolean xmlExists = new File("ngpRooms.xml").isFile();
        //if (!xmlExists)
            save(); //creates an xml file if it doesnt exit yet
        load();

    }

    public static void main(String[] args) {
        launch();
    }

    public static void save() throws Exception {
        XStream xStream = new XStream((new DomDriver()));
        ObjectOutputStream out = xStream.createObjectOutputStream(new FileWriter("ngpRooms.xml"));
        out.writeObject(NGPRun.ROOMS);
        out.close();
        System.out.println("Saved to ngpRooms.xml");
    }

    public static void load() throws Exception {
        XStream xStream = new XStream((new DomDriver()));
        xStream.addPermission(AnyTypePermission.ANY);       //granting permissions to set read object to the driver  | from: https://stackoverflow.com/questions/30812293/com-thoughtworks-xstream-security-forbiddenclassexception
        ObjectInputStream in = xStream.createObjectInputStream(new FileReader("ngpRooms.xml"));
        NGPRun.ROOMS = (RoomStore) in.readObject();   //casting readObject to type Driver
        in.close();
        System.out.println("Loaded from ngpRooms.xml");
    }


}