package tags.implementation

/**
 * https://www.acmicpc.net/problem/20232
 */
fun main() {
    val winners = mapOf(
        1995 to "ITMO",
        1996 to "SPbSU",
        1997 to "SPbSU",
        1998 to "ITMO",
        1999 to "ITMO",
        2000 to "SPbSU",
        2001 to "ITMO",
        2002 to "ITMO",
        2003 to "ITMO",
        2004 to "ITMO",
        2005 to "ITMO",
        2006 to "PetrSU, ITMO",
        2007 to "SPbSU",
        2008 to "SPbSU",
        2009 to "ITMO",
        2010 to "ITMO",
        2011 to "ITMO",
        2012 to "ITMO",
        2013 to "SPbSU",
        2014 to "ITMO",
        2015 to "ITMO",
        2016 to "ITMO",
        2017 to "ITMO",
        2018 to "SPbSU",
        2019 to "ITMO",
    )
    val year = readln().toInt()
    println(winners[year])
}
