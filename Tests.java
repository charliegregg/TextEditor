public class Tests {
    public static void test() {
        Rope r = new Rope(
            new Rope(
                new Rope(""),
                new Rope("A")
            ),
            new Rope(
                new Rope(
                    new Rope("BC"),
                    new Rope("D")
                ),
                new Rope("E")
            )
        );
        System.out.println(r.stringRep());
        System.out.println(r.length());
        System.out.println(r.get(0));
        System.out.println(r.get(1));
        System.out.println(r.get(2));
        System.out.println(r.get(3));
        System.out.println(r.sliceString(0, 0));
        System.out.println(r.sliceString(4, 0));
        System.out.println(r.sliceString(0, 1));
        System.out.println(r.sliceString(1, 1));
        System.out.println(r.sliceString(2, 1));
        System.out.println(r.sliceString(3, 1));
        System.out.println(r.sliceString(0, 2));
        System.out.println(r.sliceString(1, 2));
        System.out.println(r.sliceString(2, 2));
        System.out.println(r.sliceString(0, 3));
        System.out.println(r.sliceString(1, 3));
        System.out.println(r.sliceString(0, 4));
        System.out.println(r.sliceRope(0, 0));
        System.out.println(r.sliceRope(4, 0));
        System.out.println(r.sliceRope(0, 1));
        System.out.println(r.sliceRope(1, 1));
        System.out.println(r.sliceRope(2, 1));
        System.out.println(r.sliceRope(3, 1));
        System.out.println(r.sliceRope(0, 2));
        System.out.println(r.sliceRope(1, 2));
        System.out.println(r.sliceRope(2, 2));
        System.out.println(r.sliceRope(0, 3));
        System.out.println(r.sliceRope(1, 3));
        System.out.println(r.sliceRope(0, 4));

        System.out.println(r.insert(0, "0"));
        System.out.println(r.insert(0, "0").stringRep());
        System.out.println(r.insert(0, "0").length());
        System.out.println(r.insert(1, "1"));
        System.out.println(r.insert(1, "1").stringRep());
        System.out.println(r.insert(1, "1").length());
        System.out.println(r.insert(2, "2"));
        System.out.println(r.insert(2, "2").stringRep());
        System.out.println(r.insert(2, "2").length());
        System.out.println(r.insert(3, "3"));
        System.out.println(r.insert(3, "3").stringRep());
        System.out.println(r.insert(3, "3").length());
        System.out.println(r.insert(4, "4"));
        System.out.println(r.insert(4, "4").stringRep());
        System.out.println(r.insert(4, "4").length());
        System.out.println(r.insert(5, "5"));
        System.out.println(r.insert(5, "5").stringRep());
        System.out.println(r.insert(5, "5").length());

        System.out.println(r.insert(0, "00"));
        System.out.println(r.insert(0, "00").stringRep());
        System.out.println(r.insert(0, "00").length());
        System.out.println(r.insert(1, "11"));
        System.out.println(r.insert(1, "11").stringRep());
        System.out.println(r.insert(1, "11").length());
        System.out.println(r.insert(2, "22"));
        System.out.println(r.insert(2, "22").stringRep());
        System.out.println(r.insert(2, "22").length());
        System.out.println(r.insert(3, "33"));
        System.out.println(r.insert(3, "33").stringRep());
        System.out.println(r.insert(3, "33").length());
        System.out.println(r.insert(4, "44"));
        System.out.println(r.insert(4, "44").stringRep());
        System.out.println(r.insert(4, "44").length());
        System.out.println(r.insert(5, "55"));
        System.out.println(r.insert(5, "55").stringRep());
        System.out.println(r.insert(5, "55").length());

        System.out.println(r.remove(0, 0).stringRep());
        System.out.println(r.remove(0, 0).length());
        System.out.println(r.remove(0, 0));
        System.out.println(r.remove(4, 0).stringRep());
        System.out.println(r.remove(4, 0).length());
        System.out.println(r.remove(4, 0));
        System.out.println(r.remove(0, 1).stringRep());
        System.out.println(r.remove(0, 1).length());
        System.out.println(r.remove(0, 1));
        System.out.println(r.remove(1, 1).stringRep());
        System.out.println(r.remove(1, 1).length());
        System.out.println(r.remove(1, 1));
        System.out.println(r.remove(2, 1).stringRep());
        System.out.println(r.remove(2, 1).length());
        System.out.println(r.remove(2, 1));
        System.out.println(r.remove(3, 1).stringRep());
        System.out.println(r.remove(3, 1).length());
        System.out.println(r.remove(3, 1));
        System.out.println(r.remove(0, 2).stringRep());
        System.out.println(r.remove(0, 2).length());
        System.out.println(r.remove(0, 2));
        System.out.println(r.remove(1, 2).stringRep());
        System.out.println(r.remove(1, 2).length());
        System.out.println(r.remove(1, 2));
        System.out.println(r.remove(2, 2).stringRep());
        System.out.println(r.remove(2, 2).length());
        System.out.println(r.remove(2, 2));
        System.out.println(r.remove(0, 3).stringRep());
        System.out.println(r.remove(0, 3).length());
        System.out.println(r.remove(0, 3));
        System.out.println(r.remove(1, 3).stringRep());
        System.out.println(r.remove(1, 3).length());
        System.out.println(r.remove(1, 3));
        System.out.println(r.remove(0, 4).stringRep());
        System.out.println(r.remove(0, 4).length());
        System.out.println(r.remove(0, 4));

        Rope r2 = new Rope("This is a longer message to test the auto division of the Rope Object!");

        System.out.println(r2.stringRep());
        System.out.println(r2.length());
        System.out.println(r2);
        System.out.println(r2.insert(9, "n even").remove(43, 13).insert(43, "insertion and removal").stringRep());
        System.out.println(r2.insert(9, "n even").remove(43, 13).insert(43, "insertion and removal").length());
        System.out.println(r2.insert(9, "n even").remove(43, 13).insert(43, "insertion and removal"));
        System.out.println(r2.insert(9, "n even").remove(43, 13).insert(43, "insertion and removal").reshape().stringRep());

        Rope r3 = new Rope("This\nHas\nMultiple\nLines which are\nLong\n\nAnd short.\n");
        
        System.out.println(r3.stringRep());
        System.out.println(r3.length());
        System.out.println(r3);
        System.out.println(r3.findLineStart(0));
        System.out.println(r3.findLineEnd(0));
        System.out.println(r3.findLineStart(1));
        System.out.println(r3.findLineEnd(1));
        System.out.println(r3.findLineStart(2));
        System.out.println(r3.findLineEnd(2));
        System.out.println(r3.findLineStart(3));
        System.out.println(r3.findLineEnd(3));
        System.out.println(r3.findLineStart(4));
        System.out.println(r3.findLineEnd(4));
        System.out.println(r3.findLineStart(5));
        System.out.println(r3.findLineEnd(5));
        System.out.println(r3.findLineStart(6));
        System.out.println(r3.findLineEnd(6));
        System.out.println(r3.findLineStart(7));
        System.out.println(r3.findLineEnd(7));
        System.out.println(r3.sliceStringTo(r3.findLineStart(0), r3.findLineEnd(0)));
        System.out.println(r3.sliceStringTo(r3.findLineStart(1), r3.findLineEnd(1)));
        System.out.println(r3.sliceStringTo(r3.findLineStart(2), r3.findLineEnd(2)));
        System.out.println(r3.sliceStringTo(r3.findLineStart(3), r3.findLineEnd(3)));
        System.out.println(r3.sliceStringTo(r3.findLineStart(4), r3.findLineEnd(4)));
        System.out.println(r3.sliceStringTo(r3.findLineStart(5), r3.findLineEnd(5)));
        System.out.println(r3.sliceStringTo(r3.findLineStart(6), r3.findLineEnd(6)));
        System.out.println(r3.sliceStringTo(r3.findLineStart(7), r3.findLineEnd(7)));

        System.out.println(r3.getLineAt(0));
        System.out.println(r3.getLineAt(1));
        System.out.println(r3.getLineAt(3));
        System.out.println(r3.getLineAt(4));
        System.out.println(r3.getLineAt(5));
        System.out.println(r3.getLineAt(10));
        System.out.println(r3.getLineAt(20));
        System.out.println(r3.getLineAt(30));
        System.out.println(r3.getLineAt(40));
        System.out.println(r3.getLineAt(50));
        System.out.println(r3.getLineAt(51));



        TextEditor e = new TextEditor(r3.toString() + r2.insert(9, "n even").remove(43, 13).insert(43, "insertion and removal").toString());

        System.out.println(e.getRope());
        e.doRight().doRight().doRight().doRight().doType(" te").doType("xt");
        System.out.println(e.getRope());
        e.doDown().doDown().doType(" types of");
        System.out.println(e.getRope());
        e.doUp().doRight().doRight().doDelete().doType("m").doStartSelecting().doRight().doRight().doRight().doRight().doRight().doRight().doRight().doType("any");
        System.out.println(e.getRope());
        System.out.println(e.getRope().stringRep());
        System.out.println(e.getRope().reshape().stringRep());

    }
}