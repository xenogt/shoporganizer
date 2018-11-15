export class Order {
    id?: number;
    orderDate: Date;
    orderCompleteDate?: Date;
    shopID: number;
    paymentID: number;
    hasReturnItem?: boolean;
    returnCompleted?: boolean;
    orderNumber: string;
    notes?: string;
}