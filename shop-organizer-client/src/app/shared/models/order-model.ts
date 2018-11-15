import { Deserializable } from "../interfaces/deserializable-interface";

export class Order implements Deserializable {
    
    id?: number;
    orderDate: Date;
    orderCompleteDate?: Date;
    shopID: number;
    paymentID: number;
    hasReturnItem?: boolean;
    returnCompleted?: boolean;
    orderNumber: string;
    notes?: string;

    deserialize(input: any) {
        Object.assign(this, input);
        return this;
    }
}