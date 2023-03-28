////public class SplitTheIPRanges
////{
////
////    public static void main (String args[])
////    {
////
////        String start = "192.168.0.2";
////
////        String end = "192.168.0.254";
////
////        String[] startParts = start.split("(?<=\\.)(?!.*\\.)");
////
//////        for(int i=0;i<startParts.length;i++)
//////        {
//////            System.out.println(i);
//////        }
////
////        String[] endParts = end.split("(?<=\\.)(?!.*\\.)");
////
////        int first = Integer.parseInt(startParts[1]);
////
////        int last = Integer.parseInt(endParts[1]);
////
//////        for ( int i = first; i <= last; i++ )
//////        {
//////            System.out.println(startParts[0] + i);
//////        }
////    }
////
////}
//
//
//public class SplitTheIPRanges
//{
//
//    public static void main (String[] args)
//    {
//        String start = "192.168.0.2", end = "192.168.0.254";
//        iterate(start, end);
//        System.out.println();
//        start = "::1";
//        end = "::100";
//        iterate(start, end);
//
//        static void iterate(String lowerStr, String upperStr) throws AddressStringException  {
//        IPAddress lower = new IPAddressString(lowerStr).toAddress();
//        IPAddress upper = new IPAddressString(upperStr).toAddress();
//        IPAddressSeqRange range = lower.toSequentialRange(upper);
//        for(IPAddress addr : range.getIterable()) {
//            System.out.println(addr);
//        }
//    }
//    }
//}