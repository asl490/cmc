package pe.gob.cusco.centro_medico.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyValue<K, V> {
    private K id;
    private V value;
}