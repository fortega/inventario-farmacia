/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author felipe
 */
public class ComboBoxModelBase<T> implements ComboBoxModel<T> {
    List<T> data;
    int selected;
    public ComboBoxModelBase(List<T> data) {
        this.data = data;
    }
    
    @Override
    public void setSelectedItem(Object o) {
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).equals(o)){
                selected = i;
                return;
            }
        }
        selected = -1;
    }

    @Override
    public Object getSelectedItem() {
        return getElementAt(selected);
    }

    @Override
    public int getSize() { return data.size(); }

    @Override
    public T getElementAt(int i) {
        return data.get(i);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {}

    @Override
    public void removeListDataListener(ListDataListener ll) {}
    
}
