package per.san;

import java.util.List;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 12/28/2018 09:13
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 12/28/2018
 */
public class Test2 {
    private List<String> list;

    private int size;

    public List<String> getList() {
        int size = this.list.size() - 2;
        return list.subList(0, size);
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public int getSize() {
        return this.getList().size();
    }
}
