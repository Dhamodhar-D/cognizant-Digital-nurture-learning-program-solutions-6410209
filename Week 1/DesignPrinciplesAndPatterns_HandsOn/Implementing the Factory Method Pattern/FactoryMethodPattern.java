interface Document
{
    void open();
    void save();
    void print();
}

class WordDocument implements Document
{
    public void open()
    {
        System.out.println("Opening the word document");
    }
    public void save()
    {
        System.out.println("Saving the word document");
    }
    public void print()
    {
        System.out.println("Printing the word document");
    }
}

class PdfDocument implements Document
{
    public void open()
    {
        System.out.println("Opening the PDF document");
    }
    public void save()
    {
        System.out.println("Saving the pdf document");
    }
    public void print()
    {
        System.out.println("Printing the pdf document");
    }
}

class ExcelDocument implements Document
{
    public void open()
    {
        System.out.println("Opening the excel document");
    }
    public void save()
    {
        System.out.println("Saving the excel document");
    }
    public void print()
    {
        System.out.println("Printing the excel document");
    }
}

class Factory
{
    public Document createDocument(String type)
    {
      
        if(type.equalsIgnoreCase("WORD"))
        {
            return new WordDocument();
        }
        else if(type.equalsIgnoreCase("PDF"))
        {
            return new PdfDocument();
        }
        else if(type.equalsIgnoreCase("EXCEL"))
        {
            return new ExcelDocument();
        }
        return null;
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        Factory factory=new Factory();
        Document word=factory.createDocument("word");
        word.open();
        word.save();
        word.print();
        Document pdf=factory.createDocument("pdf");
        pdf.open();
        pdf.save();
        pdf.print();
        Document excel=factory.createDocument("excel");
        excel.open();
        excel.save();
        excel.print();
    }
}
