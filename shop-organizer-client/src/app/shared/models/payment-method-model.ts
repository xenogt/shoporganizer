import { Deserializable } from "../interfaces/deserializable-interface";

export class PaymentMethod implements Deserializable {

    paymentMethodID?: number;
    financialInstitute: string;
    accountNumber: string;
    notes?: string;

    deserialize(input: any): this {
        Object.assign(this, input);
        return this;
    }
}