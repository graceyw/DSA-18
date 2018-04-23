public class FirstFailingVersion {
    //Basically like a binary search (divide in halves)

    public static long recurse(long n, long beg, long mid, long end, IsFailingVersion isBadVersion) {  //n is final version # and isBadVersion is an object
        if (isBadVersion.isFailingVersion(beg)) {                                //base case: if beg fails
            return beg;
        }
        if (isBadVersion.isFailingVersion(mid)) {                                //if the midpoint is failing
            return recurse(n, beg, (beg+mid-1)/2,mid-1, isBadVersion);     //run the left half
        }
        else if (!isBadVersion.isFailingVersion(mid)) {                          //if midpoint is not failing
            return recurse(n,mid+1,beg+end/2, n, isBadVersion);        //run the right half
        }
        return -1;
    }

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {  //n is final version # and isBadVersion is an object
        return recurse(n,0,n/2, n, isBadVersion);
    }
}