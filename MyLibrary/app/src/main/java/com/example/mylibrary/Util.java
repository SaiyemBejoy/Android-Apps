package com.example.mylibrary;

import java.util.ArrayList;

public class Util {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;

    public static int id = 0;

    public Util() {
        if (allBooks == null) {
            allBooks = new ArrayList<>();
            initAllBooks();
        }
        if (currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (wantToReadBooks == null) {
            wantToReadBooks = new ArrayList<>();
        }
        if (alreadyReadBooks == null) {
            alreadyReadBooks = new ArrayList<>();
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addCurrentlyReadingBook(Book book) {
        return currentlyReadingBooks.add(book);
    }

    public boolean addWantToReadBook(Book book) {
        return wantToReadBooks.add(book);
    }

    public boolean addAlreadyReadBook(Book book) {
        return alreadyReadBooks.add(book);
    }

    public boolean removeCurrentlyReadingBook(Book book) {
        return currentlyReadingBooks.remove(book);
    }

    public boolean removeWantToReadBook(Book book) {
        return wantToReadBooks.remove(book);
    }

    public boolean removeAlreadyReadBook(Book book) {
        return alreadyReadBooks.remove(book);
    }

    private static void initAllBooks(){
        String name= "";
        String author = "";
        int pages = 0;
        String imageUrl = "";
        String description = "";

        id++;
        name = "Chemistry 1st Paper";
        author = "Mr Hazari";
        pages = 450;
        imageUrl = "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg";
        description = "Complex book to read";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Chemistry 2nd Paper";
        author = "Mr Naag";
        pages = 550;
        imageUrl = "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg";
        description = "Very complex book to read";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "How to program Java";
        author = "Mr Deitel";
        pages = 420;
        imageUrl = "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1338/9780133807806.jpg";
        description = "All about programming with java";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Chemistry 1st Paper";
        author = "Mr Hazari";
        pages = 450;
        imageUrl = "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg";
        description = "Complex book to read";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Chemistry 2nd Paper";
        author = "Mr Naag";
        pages = 550;
        imageUrl = "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg";
        description = "Very complex book to read";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "How to program Java";
        author = "Mr Deitel";
        pages = 420;
        imageUrl = "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1338/9780133807806.jpg";
        description = "All about programming with java";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Chemistry 1st Paper";
        author = "Mr Hazari";
        pages = 450;
        imageUrl = "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg";
        description = "Complex book to read";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Chemistry 2nd Paper";
        author = "Mr Naag";
        pages = 550;
        imageUrl = "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg";
        description = "Very complex book to read";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "How to program Java";
        author = "Mr Deitel";
        pages = 420;
        imageUrl = "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1338/9780133807806.jpg";
        description = "All about programming with java";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Chemistry 1st Paper";
        author = "Mr Hazari";
        pages = 450;
        imageUrl = "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg";
        description = "Complex book to read";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Chemistry 2nd Paper";
        author = "Mr Naag";
        pages = 550;
        imageUrl = "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg";
        description = "Very complex book to read";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "How to program Java";
        author = "Mr Deitel";
        pages = 420;
        imageUrl = "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1338/9780133807806.jpg";
        description = "All about programming with java";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Chemistry 1st Paper";
        author = "Mr Hazari";
        pages = 450;
        imageUrl = "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg";
        description = "Complex book to read";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Chemistry 2nd Paper";
        author = "Mr Naag";
        pages = 550;
        imageUrl = "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg";
        description = "Very complex book to read";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "How to program Java";
        author = "Mr Deitel";
        pages = 420;
        imageUrl = "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1338/9780133807806.jpg";
        description = "All about programming with java";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

    }
}
