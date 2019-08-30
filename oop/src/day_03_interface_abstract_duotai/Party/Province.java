package day_03_interface_abstract_duotai.Party;

public class Province extends StateCouncil  implements CentralPartyCommittee{
    @Override
    void asfetyInPriduction() {
        System.out.println("我们各" + "省人民一定按照国务院的指示进行安全生产！");
    }

    @Override
    public void partyLeader() {
        System.out.println("我们各省人民一定坚持党的领导");
    }
}
