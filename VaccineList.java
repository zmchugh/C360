import java.util.ArrayList;
public class VaccineList {
    ArrayList<VaccineEntry> vaccineList;

    public ArrayList<VaccineEntry> getVaccineList(){return this.vaccineList;}
    
    public VaccineList(ArrayList<VaccineEntry> list)
    {
        this.vaccineList = list;
    }

    public boolean add(VaccineEntry entry)
    {
        if(!exists(entry))
        {
            vaccineList.add(entry);
            return true;
        }
        return false;

    }

    public boolean exists(VaccineEntry entry)
    {
        for(int i = 0; i < vaccineList.size(); i++)
        {
            if(vaccineList.get(i).equals(entry))
                return true;
        }
        return false;
    }
}
