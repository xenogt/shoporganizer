import { Deserializable } from "../interfaces/deserializable-interface";

export class Payment implements Deserializable {
    
    paymentID?: number;
    paymentMethodID: number;
    payOnDate: Date;
    notes?: string;
    confirmation?: string;

    deserialize(input: any): this {
        Object.assign(this, input);
        return this;
    }
}