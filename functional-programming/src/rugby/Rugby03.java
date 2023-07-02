package rugby;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Rugby03 {
  public static void main(String[] args) {
    List<Club> table = Arrays.asList(
        new Club(1, "Northampton Saints", 22, 16, 1, 5, 621, 400, 221, 75, 41,
            8, 2, 76),
        new Club(2, "Bath", 22, 16, 0, 6, 625, 414, 211, 72, 43, 9, 2, 75),
        new Club(3, "Leicester Tigers", 22, 15, 1, 6, 453, 421, 32, 37, 39, 4,
            2, 68),
        new Club(4, "Saracens", 22, 14, 1, 7, 664, 418, 246, 70, 40, 5, 5, 68),
        new Club(5, "Exeter Chiefs", 22, 14, 0, 8, 663, 437, 226, 70, 46, 5, 7,
            68),
        new Club(6, "Wasps", 22, 11, 2, 9, 672, 527, 145, 77, 54, 9, 4, 61),
        new Club(7, "Sale Sharks", 22, 11, 0, 11, 497, 482, 15, 62, 54, 6, 4,
            54),
        new Club(8, "Harlequins", 22, 10, 0, 12, 444, 514, -70, 45, 50, 4, 5,
            49),
        new Club(9, "Gloucester", 22, 9, 1, 12, 553, 575, -22, 53, 61, 4, 6,
            48),
        new Club(10, "London Irish", 22, 7, 1, 14, 442, 578, -136, 46, 57, 4, 6,
            40),
        new Club(11, "Newcastle Falcons", 22, 5, 1, 16, 475, 545, -70, 57, 61,
            4, 8, 34),
        new Club(12, "London Welsh", 22, 0, 0, 22, 223, 1021, -798, 29, 147, 1,
            0, 1));


    OptionalInt min = table.stream().mapToInt(Club::getPoints).min();
    if (min.isPresent()) {
      System.out.printf("Lowest number of points is %d\n", min.getAsInt());
    } else {
      System.out.println("min failed");
    }
  }

}
